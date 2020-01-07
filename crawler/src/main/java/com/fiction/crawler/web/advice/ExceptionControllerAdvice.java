package com.fiction.crawler.web.advice;

import com.fiction.crawler.domain.response.CommonResponse;
import com.fiction.crawler.web.exception.CongestionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

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

    @ResponseBody
    @ExceptionHandler(value = CongestionException.class)
    public String Except(CongestionException throwable) {
//        HashMap hashMap = new HashMap();
//        hashMap.put("errcode", 403);
//        hashMap.put("errMsg", throwable.getMessage());
        return throwable.getMessage();
    }


}
