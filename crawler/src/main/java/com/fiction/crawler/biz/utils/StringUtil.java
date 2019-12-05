package com.fiction.crawler.biz.utils;

import java.util.UUID;

public final class StringUtil {

    public static String createToken() {
        return UUID.randomUUID().toString().replace("-", "").substring(0,5);
    }
    /**
     * Check if a string is empty
     * @param s
     * @return
     */
    public static boolean isEmpty(String s){
        return s == null || s.trim().length() == 0;
    }


}
