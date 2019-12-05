package com.fiction.crawler.web.advice;

import com.fiction.crawler.domain.response.CommonResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * 未处理异常 统一处理
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResponse exceptionHandler(Exception e) {
        return CommonResponse.failure("系统异常");
    }

}
