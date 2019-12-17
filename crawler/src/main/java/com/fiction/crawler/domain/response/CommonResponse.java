package com.fiction.crawler.domain.response;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
    private Integer pageSize;
    private Integer pageNum;
    private List<T> list;
    private Long total;


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
    public static <T> CommonResponse successPage(List<T> data){
        CommonResponse<T> commonResponse = new CommonResponse<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(data);
        commonResponse.setSuccess(true);
        commonResponse.setTotalPage(pageInfo.getPages());
        commonResponse.setPageNum(pageInfo.getPageNum());
        commonResponse.setPageSize(pageInfo.getPageSize());
        commonResponse.setList(data);
        commonResponse.setTotal(pageInfo.getTotal());
        return commonResponse;
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
