package com.fiction.crawler.web.controller;

import com.fiction.crawler.biz.serives.CrawlerService;
import com.fiction.crawler.domain.request.CrawlerRequest;
import com.fiction.crawler.domain.response.CommonResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Date: 2019/3/22 13:53:38
 */
@RestController
@RequestMapping("/fc/")
public class CrawlerController {

    @Resource
    private CrawlerService crawlerService;
    /**
     * 抓取请求
     * @return JSON串
     */
    @RequestMapping("crawler")
    public CommonResponse byName(CrawlerRequest request){
        //异步抓取 直接返回
        return crawlerService.dealCrawler(request.getUrl(), request.getWebType());
    }


}
