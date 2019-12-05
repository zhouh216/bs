package com.fiction.crawler.domain.enums;

import java.util.Objects;

/**
 * the introduction of class
 *
 * @date 2019/4/17 17:50:50
 */
public enum OrderTypeEnum {
    SUBSCRIPTION(1,"喜欢"),
    COLLECT(2,"收藏"),
    CLICK(3,"点击"),
    ;

    private Integer type;
    private String desc;

    OrderTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static OrderTypeEnum typeOf(Integer type) {
        for (OrderTypeEnum fictionTypeEnum : OrderTypeEnum.values()) {
            if (Objects.equals(fictionTypeEnum.type, type)) {
                return fictionTypeEnum;
            }
        }
        return null;
    }
}
