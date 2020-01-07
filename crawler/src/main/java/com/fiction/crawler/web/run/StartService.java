package com.fiction.crawler.web.run;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

/**
 * @program: crawler
 * @description:
 * @author: zh
 * @create: 2019-12-26 16:15
 **/
@Service
public class StartService implements ApplicationRunner {

    @Autowired
    private CuratorFramework curatorFramework;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        curatorFramework.start();
        System.out.println("curatorFramework启动");
    }
}
