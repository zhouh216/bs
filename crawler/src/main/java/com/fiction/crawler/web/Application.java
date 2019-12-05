package com.fiction.crawler.web;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
@MapperScan(basePackages = "com.fiction.crawler.biz.dao")
@ComponentScan(basePackages={"com.fiction.crawler.*"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean("uts1")
    @ConfigurationProperties(prefix = "spring.datasource.uts1")
    @Primary
    public DataSource uts1DataSource(){
        DruidDataSource ds = new DruidDataSource();
        return ds;
    }
    
    @Bean("uts2")
    @ConfigurationProperties(prefix = "spring.datasource.uts2")
    public DataSource uts2DataSource(){
        DruidDataSource ds = new DruidDataSource();
        return ds;
    }

}
