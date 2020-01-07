package com.fiction.crawler.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @program: crawler
 * @description:
 * @author: zh
 * @create: 2019-12-26 19:12
 **/
@Component
public class RedisPoolUtil {
    @Autowired
    private JedisPool jedisPool;

    private String password;

    public Jedis getJedis(){
        Jedis jedis = jedisPool.getResource();
        if(!StringUtils.isEmpty(password)){
            jedis.auth(password);
        }
        return jedis;
    }
}
