package com.fiction.crawler.web;

/**
 * @program: crawler
 * @description:
 * @author: zh
 * @create: 2019-11-29 11:42
 **/
public class SelectorUtil {
    public static Pair<Integer, Integer> getDataBaseAndTableNumber(String uid) {
        int hashCode = Math.abs(uid.hashCode());
        int dbNumber = hashCode / 10 % 4 + 1;
        int tableNumber = hashCode % 10;
        return new Pair<Integer, Integer>(dbNumber, tableNumber);
    }
}
