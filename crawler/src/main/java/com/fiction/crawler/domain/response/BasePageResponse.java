package com.fiction.crawler.domain.response;

import lombok.Data;

import java.io.Serializable;

/**
 * the introduction of class
 *
 * @date 2019/4/18 19:24:39
 */
@Data
public class BasePageResponse implements Serializable {
    private Integer totalPage;
    private Integer currentPage;
}
