package com.fiction.crawler.web.controller;

import com.fiction.crawler.biz.serives.FictionService;
import com.fiction.crawler.domain.request.FictionRequest;
import com.fiction.crawler.domain.response.CommonResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Date: 2019/3/22 13:53:38
 */
@RestController
@RequestMapping("/fc/search/")
public class FictionController {

    @Resource
    private FictionService fictionService;

    /**
     * 搜索通用接口
     *
     * @return JSON串
     */
    @RequestMapping("byName")
    public CommonResponse byName(FictionRequest request) {
        return fictionService.getListByName(request);
    }

    /**
     * 收藏榜
     *
     * @return JSON串
     */
    @RequestMapping("collectOrder")
    public CommonResponse collectOrder(FictionRequest request) {
        return fictionService.getCollectOrder(request);
    }

    /**
     * 点击榜
     *
     * @return JSON串
     */
    @RequestMapping("clickOrder")
    public CommonResponse clickOrder(FictionRequest request) {
        return fictionService.getClickOrder(request);
    }

    /**
     * 喜欢榜
     *
     * @return JSON串
     */
    @RequestMapping("subscriptionOrder")
    public CommonResponse subscriptionOrder(FictionRequest request) {
        return fictionService.getSubscriptionOrder(request);
    }

    /**
     * 男生榜
     *
     * @return JSON串
     */
    @RequestMapping("male")
    public CommonResponse male(FictionRequest request) {
        return fictionService.male(request);
    }

    /**
     * 女生榜
     *
     * @return JSON串
     */
    @RequestMapping("female")
    public CommonResponse female(FictionRequest request) {
        return fictionService.female(request);
    }

    /**
     * 言情榜
     *
     * @return JSON串
     */
    @RequestMapping("romantic")
    public CommonResponse romantic(FictionRequest request) {
        return fictionService.romantic(request);
    }

    /**
     * 都市榜
     *
     * @return JSON串
     */
    @RequestMapping("urban")
    public CommonResponse urban(FictionRequest request) {
        return fictionService.urban(request);
    }

    /**
     * 初始化数据
     *
     * @return JSON串
     */
    @RequestMapping("afterLoad")
    public CommonResponse afterLoad(FictionRequest request) {
        return fictionService.afterLoad(request);
    }

    @RequestMapping("list")
    public CommonResponse list(){
        return fictionService.list();
    }

    /**
     * 详情
     *
     * @return JSON串
     */
    @RequestMapping("detail")
    public CommonResponse detail(FictionRequest request) {
        return fictionService.detail(request);
    }

    /**
     * 收藏功能
     *
     * @return JSON串
     */
    @RequestMapping("collect")
    public CommonResponse collect(FictionRequest request) {
        return fictionService.collect(request);
    }

    /**
     * 喜欢功能
     *
     * @return JSON串
     */
    @RequestMapping("subscription")
    public CommonResponse subscription(FictionRequest request) {
        return fictionService.subscription(request);
    }
}
