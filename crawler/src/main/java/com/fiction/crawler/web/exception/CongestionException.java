package com.fiction.crawler.web.exception;

/**
 * @program: crawler
 * @description:
 * @author: zh
 * @create: 2019-12-26 16:55
 **/
public class CongestionException extends Exception{
    public CongestionException() {
        super("当前业务繁忙，请稍后再试");
    }
}
