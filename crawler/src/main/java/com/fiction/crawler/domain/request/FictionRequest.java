package com.fiction.crawler.domain.request;

import lombok.Data;

//小说请求实体类
@Data
public class FictionRequest extends BasePageRequest {

    private Integer id;

    private String fictionName;

    private String key;

    private Integer num;

}
