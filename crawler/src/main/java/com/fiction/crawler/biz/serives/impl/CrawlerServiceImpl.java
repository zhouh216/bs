package com.fiction.crawler.biz.serives.impl;

import com.fiction.crawler.biz.crawler.CrawlerContext;
import com.fiction.crawler.biz.serives.CrawlerService;
import com.fiction.crawler.domain.response.CommonResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * the introduction of class
 *
 *
 * @date 2019/4/18 19:53:17
 */
@Service("crawlerService")
public class CrawlerServiceImpl implements CrawlerService {


    @Resource
    private CrawlerContext crawlerContext;

    //爬虫抓取
    @Override
    public CommonResponse dealCrawler(String url, Integer webType) {
        if(StringUtils.isBlank(url) || webType == null){
            return CommonResponse.failure("参数异常");
        }
        return crawlerContext.dealCrawler(url, webType);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for(String s:list){
            if("1".equals(s)){
                System.out.println(list.remove(s));
            }
        }
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            if(iterator.next().equals("1")){
//                iterator.remove();
//            }
//        }
        list.forEach(x-> System.out.println(x));
    }
}
