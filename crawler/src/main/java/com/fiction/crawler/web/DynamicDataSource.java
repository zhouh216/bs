package com.fiction.crawler.web;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @program: crawler
 * @description:
 * @author: zh
 * @create: 2019-11-29 11:34
 **/
public class DynamicDataSource  extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {

        return DataBaseContextHolder.getDataBaseType();
    }
}
