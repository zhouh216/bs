package com.fiction.crawler.biz.crawler;

import com.fiction.crawler.domain.enums.WebTypeEnum;
import com.fiction.crawler.domain.response.CommonResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * the introduction of class
 * @date 2019/4/19 20:50:04
 */
@Component
public class CrawlerContext {
    @Resource
    private HttpAbstractCrawler factionReadingWebCrawler;
    //处理抓取请求的
    public CommonResponse dealCrawler(String url, Integer webType) {
        WebTypeEnum webTypeEnum = WebTypeEnum.typeOf(webType);
        switch (webTypeEnum) {
            //目前只抓取 小说网 后续扩展可继承HttpAbstractCrawler
            case FACTION_READING_WEB:
                try {
                    factionReadingWebCrawler.dealCrawler(url);
                    return CommonResponse.success(true);
                } catch (Exception e) {
                    //不抛异常就是正在抓取
                    return CommonResponse.failure(e.getMessage());
                }
            case ONE_SEVEN_K:
                break;
        }
        return CommonResponse.failure("暂不支持抓取");
    }
}
