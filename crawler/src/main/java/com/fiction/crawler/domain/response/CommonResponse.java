package com.fiction.crawler.domain.response;

import lombok.Data;

import java.io.Serializable;

/**
 * the introduction of class
 *
 * @date 2019/4/18 19:27:25
 */
//返回页面信息实体类
@Data
public class CommonResponse<T> extends BasePageResponse{
    private boolean success = false;
    private String errMsg = "";
    private String sucMsg="";
    private T data;
    public static final int ERRORCODE=-1;

    public static <T> CommonResponse success(T data) {
        CommonResponse commonRequest = new CommonResponse();
        commonRequest.setSuccess(true);
        commonRequest.setData(data);
        return commonRequest;
    }
    public static <T> CommonResponse successPage(T data,Integer totalPage,Integer currentPage) {
        CommonResponse commonRequest = new CommonResponse();
        commonRequest.setSuccess(true);
        commonRequest.setData(data);
        commonRequest.setTotalPage(totalPage);
        commonRequest.setCurrentPage(currentPage);
        return commonRequest;
    }
    public static <T> CommonResponse success(String sucMsg, T data) {
        CommonResponse commonRequest = new CommonResponse();
        commonRequest.setSuccess(true);
        commonRequest.setData(data);
        commonRequest.setSucMsg(sucMsg);
        return commonRequest;
    }

    public static CommonResponse failure(String msg) {
        CommonResponse commonRequest = new CommonResponse();
        commonRequest.setSuccess(false);
        commonRequest.setErrMsg(msg);
        return commonRequest;
    }
}
