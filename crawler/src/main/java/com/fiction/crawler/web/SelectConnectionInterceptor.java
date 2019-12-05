package com.fiction.crawler.web;

import com.fiction.crawler.biz.serives.impl.SelectConnection;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @program: crawler
 * @description: 数据源切面
 * @author: zh
 * @create: 2019-11-29 11:38
 **/
@Aspect
@Component
public class SelectConnectionInterceptor implements Ordered {
    private static final String DB_PREFIX = "uts";

    @Around("@annotation(selectConnection)")
    public Object proceed(ProceedingJoinPoint joinPoint, SelectConnection selectConnection) throws Throwable {
        String dbName = "";
        if (!StringUtils.isBlank(selectConnection.name())) {
            dbName = selectConnection.name();
        }
//        else {
//            DataBaseContextHolder.DataBaseType baseEntity = (DataBaseContextHolder.DataBaseType) joinPoint.getArgs()[0];
//            Pair<Integer, Integer> pair = SelectorUtil.getDataBaseAndTableNumber(baseEntity.getCode());
//            dbName = DB_PREFIX + pair.getObject1();
//        }
        DataBaseContextHolder.setDataBaseType(DataBaseContextHolder.DataBaseType.valueOf(dbName));
        Object result = joinPoint.proceed();
        DataBaseContextHolder.clearContextHolder();
        System.out.println("执行成功"+result);
        return result;

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
