package com.fiction.crawler.domain.request;

import lombok.Data;

/**
 * the introduction of class
 *
 * @date 2019/4/18 19:24:39
 */
//爬虫抓取请求实体类
@Data
public class CrawlerRequest {
    private String url;
    private Integer webType;
}
