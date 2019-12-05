package com.fiction.crawler.biz.serives;


import com.fiction.crawler.domain.response.CommonResponse;

/**
 * @Date: 2019/3/22 14:43:32
 */
public interface CrawlerService {
    /**
     * 抓取
     * @param url 地址
     * @param webType 抓取网站类型
     */
    CommonResponse dealCrawler(String url, Integer webType);
}
