package com.fiction.crawler.web.controller;

import com.fiction.crawler.biz.serives.LockService;
import com.fiction.crawler.web.exception.CongestionException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.locks.Lock;

/**
 * @program: crawler
 * @description:
 * @author: zh
 * @create: 2019-12-26 15:16
 **/
@RestController
public class TestLockController {
    @Resource
    private LockService lockService;

    @RequestMapping("/order")
    public String order(String product_id)throws CongestionException {
        return lockService.order(product_id);
    }
}
