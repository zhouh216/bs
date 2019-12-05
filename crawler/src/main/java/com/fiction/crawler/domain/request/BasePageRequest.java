package com.fiction.crawler.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * the introduction of class
 *
 * @date 2019/4/18 19:24:39
 */
public class BasePageRequest implements Serializable {
    private Integer page;

    public Integer getPage() {
        return page == null ? 1 : page;
    }

    public Integer getRealPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
