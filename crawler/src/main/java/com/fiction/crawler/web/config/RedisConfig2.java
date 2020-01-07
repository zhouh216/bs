package com.fiction.crawler.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @program: crawler
 * @description:
 * @author: zh
 * @create: 2019-12-26 19:11
 **/
@Configuration
public class RedisConfig2 {
    @Bean
    JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(500);//最大连接数，连接全部用完，进行等待
        poolConfig.setMinIdle(10); //最小空余数
        poolConfig.setMaxIdle(10); //最大空余数
        poolConfig.setMaxWaitMillis(10000);
        poolConfig.setTestOnBorrow(false);
        return poolConfig;
        //pool = new JedisPool("127.0.0.1",6379);
    }
    @Bean
    JedisPool jedisPool(JedisPoolConfig jedisPoolConfig){
        JedisPool pool = new JedisPool(jedisPoolConfig,"192.168.32.100",6379,1000);
        return pool;
    }
}
