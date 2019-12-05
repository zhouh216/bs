package com.fiction.crawler.domain.enums;

import java.util.Objects;

/**
 * the introduction of class
 *
 * @date 2019/4/17 17:50:50
 */
public enum FictionIsOverEnum {
    LOADING(0,"加载中"),
    FINISH(1,"已完结"),
    ;

    private Integer type;
    private String desc;

    FictionIsOverEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static FictionIsOverEnum typeOf(Integer type) {
        for (FictionIsOverEnum fictionIsOverEnum : FictionIsOverEnum.values()) {
            if (Objects.equals(fictionIsOverEnum.type, type)) {
                return fictionIsOverEnum;
            }
        }
        return FictionIsOverEnum.LOADING;
    }
    public static FictionIsOverEnum descOf(String desc) {
        for (FictionIsOverEnum fictionTypeEnum : FictionIsOverEnum.values()) {
            if (Objects.equals(fictionTypeEnum.desc, desc)) {
                return fictionTypeEnum;
            }
        }
        return FictionIsOverEnum.LOADING;
    }
}
