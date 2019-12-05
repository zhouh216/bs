package com.fiction.crawler.domain.enums;

import java.util.Objects;

/**
 * the introduction of class
 *
 * @date 2019/4/17 17:50:50
 */
public enum SixTypeEnum {
    FEMALE(0,"女"),
    MALE(1,"男"),
    ;

    private Integer type;
    private String desc;

    SixTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static SixTypeEnum typeOf(Integer type) {
        for (SixTypeEnum fictionTypeEnum : SixTypeEnum.values()) {
            if (Objects.equals(fictionTypeEnum.type, type)) {
                return fictionTypeEnum;
            }
        }
        return null;
    }
}
