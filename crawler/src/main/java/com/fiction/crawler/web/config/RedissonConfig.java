package com.fiction.crawler.web.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: crawler
 * @description:
 * @author: zh
 * @create: 2019-12-27 09:50
 **/
@Configuration
public class RedissonConfig {
    @Bean
    public Redisson redissonSingle() {
        //支持Single单机，Master/Slave 主从，Sentinel哨兵，Cluster集群等模式
        //此为单机模式
        Config config = new Config();
        config.useSingleServer()
                .setAddress("192.168.32.100:6379")
                .setTimeout(100000);
        return (Redisson)Redisson.create(config);
    }
}
