package com.fiction.crawler.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

//小说返回前端的实体类
@Data
public class FictionInfoVO implements Serializable {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String fictionName;

    private String fictionAuthor;

    private String img;

    private String isOver;

    private String fictionSize;

    private Integer fictionType;

    private Integer sexType;

    private Integer subscriptionNum;

    private Integer collectNum;

    private Integer clickNum;

    private String ext;

    private Integer axFlag;

    private Integer wjxFlag;

}