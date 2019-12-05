package com.fiction.crawler.biz.utils;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * the introduction of class
 *
 * @date 2019/4/19 20:21:22
 */
@Component
public class GeneralConstants {
    public final Map<String,Object> mapCache = Maps.newHashMap();
}
