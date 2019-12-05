package com.fiction.crawler.biz.crawler;

import com.fiction.crawler.biz.crawler.CrawlerService;
import com.fiction.crawler.biz.crawler.FactionReadingWebCrawler;
import com.fiction.crawler.biz.crawler.HttpAbstractCrawler;
import com.fiction.crawler.biz.utils.JSoupUtils;
import com.fiction.crawler.domain.dto.FictionInfo;
import com.google.common.collect.Maps;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.Map;

public class CrawlerMain {
    public static void main(String[] args) throws IOException {

        CrawlerService crawler = new CrawlerService();
        File file = new File("D:/html.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileOutputStream =null;
        try {
            fileOutputStream=new FileWriter("D:/html.txt");
        }catch (FileNotFoundException e){
            System.out.println("未找到html");
        }
        //掘金小册 抓取下来使用Unicode编码
        String url="https://xiaoce-cache-api-ms.juejin.im/v1/getSection?uid=5cb182c7f265da03973a9f0a&client_id=1566292193476&token=eyJhY2Nlc3NfdG9rZW4iOiI4MllrOUFwcHFucEhidGVHIiwicmVmcmVzaF90b2tlbiI6InpHSjk4S3VUeE9tRkZTMDciLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&sectionId=5c0374a06fb9a049d37ed783";
        //缓存
        Map<String, FictionInfo> map = Maps.newHashMap();
        //获取根地址
        String rootUrl = url.split(".com/")[0] + ".com";
        Document document = null;
        try {
            document = JSoupUtils.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (document == null) {
            return;
        }
        fileOutputStream.write(document.outerHtml());

        fileOutputStream.close();
    }
}
