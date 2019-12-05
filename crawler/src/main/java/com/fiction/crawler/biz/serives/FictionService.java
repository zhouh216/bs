package com.fiction.crawler.biz.serives;


import com.fiction.crawler.domain.dto.FictionInfo;
import com.fiction.crawler.domain.request.FictionRequest;
import com.fiction.crawler.domain.response.CommonResponse;

import java.util.List;

/**
 * @Date: 2019/3/22 14:43:32
 */
public interface FictionService {
    /**
     * 搜索
     * @param name
     * @return user
     */
    CommonResponse<List<FictionInfo>> getListByName(FictionRequest request);

    CommonResponse<List<FictionInfo>> getCollectOrder(FictionRequest request);

    CommonResponse<List<FictionInfo>> getClickOrder(FictionRequest request);

    CommonResponse<List<FictionInfo>> getSubscriptionOrder(FictionRequest request);

    CommonResponse male(FictionRequest request);

    CommonResponse female(FictionRequest request);

    CommonResponse romantic(FictionRequest request);

    CommonResponse urban(FictionRequest request);

    CommonResponse detail(FictionRequest request);

    CommonResponse afterLoad(FictionRequest request);

    CommonResponse collect(FictionRequest request);

    CommonResponse subscription(FictionRequest request);

    CommonResponse list();
}
