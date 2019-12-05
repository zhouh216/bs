package com.fiction.crawler.domain.enums;

import java.util.Objects;

/**
 * the introduction of class
 *
 * @date 2019/4/17 17:50:50
 */
public enum FictionTypeEnum {
    URBAN(1,"都市"),
    ROMANTIC(2,"言情"),
    OTHER(-1,"其他"),
    ;

    private Integer type;
    private String desc;

    FictionTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static FictionTypeEnum typeOf(Integer type) {
        for (FictionTypeEnum fictionTypeEnum : FictionTypeEnum.values()) {
            if (Objects.equals(fictionTypeEnum.type, type)) {
                return fictionTypeEnum;
            }
        }
        return null;
    }
    public static FictionTypeEnum descOf(String desc) {
        for (FictionTypeEnum fictionTypeEnum : FictionTypeEnum.values()) {
            if (Objects.equals(fictionTypeEnum.type, desc)) {
                return fictionTypeEnum;
            }
        }
        return FictionTypeEnum.OTHER;
    }
}
