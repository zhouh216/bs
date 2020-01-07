package com.fiction.crawler.biz.serives;

import com.fiction.crawler.web.exception.CongestionException;

public interface LockService {

    public String order(String productiD) throws CongestionException;
}
