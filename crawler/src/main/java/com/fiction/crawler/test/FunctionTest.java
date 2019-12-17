package com.fiction.crawler.test;

import java.util.Date;
import java.util.function.Function;

/**
 * @program: crawler
 * @description:
 * @author: zh
 * @create: 2019-12-16 08:55
 **/
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        String function = test.function((date) -> {
            return date.toString();
        }, new Date());
        System.out.println(function);
    }

    public String function(Function<Date,String> function,Date date){
        String apply = function.apply(date);
        return apply;
    }
}
