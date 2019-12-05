package com.fiction.crawler.domain.enums;

import java.util.Objects;

/**
 * the introduction of class
 *
 * @date 2019/4/17 17:50:50
 */
public enum WebTypeEnum {
    FACTION_READING_WEB(1,"小说阅读网"),
    ONE_SEVEN_K(2,"17k小说"),
    ;

    private Integer type;
    private String desc;

    WebTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static WebTypeEnum typeOf(Integer type) {
        for (WebTypeEnum fictionTypeEnum : WebTypeEnum.values()) {
            if (Objects.equals(fictionTypeEnum.type, type)) {
                return fictionTypeEnum;
            }
        }
        return null;
    }
}
