package com.fiction.crawler.web;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: crawler
 * @description: MybatisConfiguration
 * @author: zh
 * @create: 2019-11-29 11:35
 **/
@Configuration
@EnableTransactionManagement
public class MybatisConfiguration {
    @Resource(name = "uts1")
    private DataSource duts1DataSource;
    @Resource(name = "uts2")
    private DataSource duts2DataSource;

    @Bean
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataBaseContextHolder.DataBaseType.uts1, duts1DataSource);
        targetDataSources.put(DataBaseContextHolder.DataBaseType.uts2, duts2DataSource);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(dynamicDataSource);
        return dynamicDataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(DynamicDataSource dynamicDataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        //添加拦截器
        DynamicDataSourceInterceptor interceptor = new DynamicDataSourceInterceptor();
        bean.setPlugins(new Interceptor[]{interceptor});
        // 添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath*:sql/**/*.xml"));
            SqlSessionFactory sqlSessionFactory = bean.getObject();
            sqlSessionFactory.getConfiguration().setCacheEnabled(Boolean.TRUE);
            
            return sqlSessionFactory;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public PlatformTransactionManager transactionManager(DynamicDataSource dynamicDataSource) throws Exception {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dynamicDataSource);
        return txManager;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
}
