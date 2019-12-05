package com.fiction.crawler.biz.serives.impl;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SelectConnection {
    String name() default "";
}
