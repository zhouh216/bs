package com.fiction.crawler.web;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Locale;
import java.util.Properties;

/**
 * @program: bs
 * @description: 读写分离mybatis拦截器
 * @author: zh
 * @create: 2019-12-05 09:12
 **/
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
        @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class })
})
public class DynamicDataSourceInterceptor implements Interceptor {
    // 验证是否为写SQL的正则表达式
    private static final String REGEX = ".*insert\\u0020.*|.*delete\\u0020.*|.*update\\u0020.*";
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 判断当前是否被事务管理
        boolean synchronizationActive = TransactionSynchronizationManager.isActualTransactionActive();
        //默认主库 1是主库 2是从库
        DataBaseContextHolder.setDataBaseType(DataBaseContextHolder.DataBaseType.uts1);
        if (!synchronizationActive) {
            //如果是非事务的，则再判断是读或者写。
            // 获取SQL中的参数
            Object[] objects = invocation.getArgs();
            // object[0]会携带增删改查的信息，可以判断是读或者是写
            MappedStatement ms = (MappedStatement) objects[0];
            // 如果为读，且为自增id查询主键，则使用主库
            // 这种判断主要用于插入时返回ID的操作，由于日志同步到从库有延时
            // 所以如果插入时需要返回id，则不适用于到从库查询数据，有可能查询不到
            if (ms.getSqlCommandType().equals(SqlCommandType.SELECT)
                    && ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)) {
                DataBaseContextHolder.setDataBaseType(DataBaseContextHolder.DataBaseType.uts2);
            } else {
                BoundSql boundSql = ms.getSqlSource().getBoundSql(objects[1]);
                String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replaceAll("[\\t\\n\\r]", " ");
                // 正则验证
                if (sql.matches(REGEX)) {
                    // 如果是写语句
                    DataBaseContextHolder.setDataBaseType(DataBaseContextHolder.DataBaseType.uts2);
                } else {
                    DataBaseContextHolder.setDataBaseType(DataBaseContextHolder.DataBaseType.uts1);
                }
            }
        } else {
            // 如果是通过事务管理的，一般都是写语句,直接通过主库
            DataBaseContextHolder.setDataBaseType(DataBaseContextHolder.DataBaseType.uts1);
        }
        // 最后直接执行SQL
        return invocation.proceed();
    }

    /**
     * 返回封装好的对象，或代理对象
     */
    @Override
    public Object plugin(Object target) {
        // 如果存在增删改查，则直接拦截下来，否则直接返回
        if (target instanceof Executor)
            return Plugin.wrap(target, this);
        else
            return target;
    }
    /**
     * 类初始化的时候做一些相关的设置
     */
    @Override
    public void setProperties(Properties properties) {

    }
}
