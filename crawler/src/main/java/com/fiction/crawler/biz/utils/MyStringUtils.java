package com.fiction.crawler.biz.utils;

import java.util.UUID;

/**
 * @program: crawler
 * @description:
 * @author: zh
 * @create: 2019-12-26 16:52
 **/
public class MyStringUtils {
    public static String getuuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    public static String Object2String(Object o) {
        if (o == null) {
            return "";
        } else {
            return o.toString();
        }
    }
}
