package com.fiction.crawler.biz.serives.impl;

import com.alibaba.fastjson.JSON;
import com.fiction.crawler.biz.dao.mapper.FictionContentMapper;
import com.fiction.crawler.biz.dao.mapper.UserMapper;
import com.fiction.crawler.biz.dao.sql.FictionInfoDao;
import com.fiction.crawler.biz.serives.FictionService;
import com.fiction.crawler.biz.utils.GeneralConstants;
import com.fiction.crawler.domain.dto.FictionContent;
import com.fiction.crawler.domain.dto.FictionContentExample;
import com.fiction.crawler.domain.dto.FictionInfo;
import com.fiction.crawler.domain.dto.User;
import com.fiction.crawler.domain.enums.FictionTypeEnum;
import com.fiction.crawler.domain.enums.OrderTypeEnum;
import com.fiction.crawler.domain.enums.SixTypeEnum;
import com.fiction.crawler.domain.request.FictionRequest;
import com.fiction.crawler.domain.response.CommonResponse;
import com.fiction.crawler.domain.vo.FictionInfoVO;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 */
@Service("fictionService")
public class FictionServiceImpl implements FictionService {

    @Resource
    private FictionInfoDao fictionInfoDao;

    @Resource
    private FictionContentMapper fictionContentMapper;


    @Resource
    private UserMapper userMapper;


    @Resource
    private GeneralConstants generalConstants;

    @Override
    public CommonResponse list() {
        Map<String,Object> map = new HashMap<>();
        List<Integer> integers = new ArrayList<>();
        integers.add(40);
        integers.add(41);
        integers.add(42);
        integers.add(43);
        map.put("inList",integers);
        List<Map<String, Object>> resultMap = fictionInfoDao.selectList(map);
        return CommonResponse.success(resultMap);
    }

    //搜索功能
    @Override
    public CommonResponse getListByName(FictionRequest request) {
        String name = request.getFictionName();
        Map<String, Object> param = new HashMap<>();
        param.put("name", name);
        param.put("start", (request.getPage() - 1) * 12);
        param.put("pageSize", 12);
        List<FictionInfo> fictionInfos;
        //查询出数量
        Integer count = fictionInfoDao.selectByNameCount(param);
        int totalPage = count % 12 == 0 ? (count / 12) : count / 12 + 1;

        if (count == null || count == 0) {
            param.put("start", 0);
            param.put("orderType", 3);
            fictionInfos = fictionInfoDao.selectByOrderType(param);
        } else {
            fictionInfos = fictionInfoDao.selectByName(param);
        }
        //模糊查询不足12个 推荐相同类型 点击量多
        if (fictionInfos.size() < 12) {
            param.put("start", 0);
            param.put("fictionType", fictionInfos.get(0).getFictionType());
            param.put("pageSize", 12 - fictionInfos.size());
            param.put("notInList",fictionInfos.stream().map(FictionInfo::getId).collect(Collectors.toList()));
            List<FictionInfo> fictionInfoSub = fictionInfoDao.selectByOrderType(param);
            fictionInfos.addAll(fictionInfoSub);
        }
        User loginUser = (User)generalConstants.mapCache.get(request.getKey());
        List<FictionInfoVO> vos = generateVO(fictionInfos,loginUser);
        return CommonResponse.successPage(vos, totalPage, request.getPage());
    }

    //获取该用户的喜欢列表 进行返回前端页面
    private List<FictionInfoVO> generateVO(List<FictionInfo> fictionInfos,User user) {
        String subscriptionListStr = user.getSubscriptionList();
        List<String> subscriptionList;
        if(StringUtils.isBlank(subscriptionListStr)){
            subscriptionList = new ArrayList<>();
        }else{
            subscriptionList = JSON.parseArray(subscriptionListStr,String.class);
        }
        String collectListStr = user.getCollectList();
        List<String> collectList;
        if(StringUtils.isBlank(collectListStr)){
            collectList = new ArrayList<>();
        }else{
            collectList = JSON.parseArray(collectListStr,String.class);
        }
        List<FictionInfoVO> vos = Lists.newArrayList();
        if(CollectionUtils.isEmpty(fictionInfos)){
            return vos;
        }
        fictionInfos.forEach(fictionInfo -> {
            FictionInfoVO fictionInfoVO = new FictionInfoVO();
            BeanUtils.copyProperties(fictionInfo,fictionInfoVO);
            fictionInfoVO.setWjxFlag(collectList.contains(fictionInfo.getId().toString()) ? 1 : 0);
            fictionInfoVO.setAxFlag(subscriptionList.contains(fictionInfo.getId().toString()) ? 1 : 0);
            vos.add(fictionInfoVO);
        });
        return vos;
    }

    //收藏榜
    @Override
    public CommonResponse getCollectOrder(FictionRequest request) {
        Map<String, Object> param = new HashMap<>();
        param.put("start", (request.getPage() - 1) * 12);
        param.put("pageSize", 12);
        param.put("orderType", OrderTypeEnum.COLLECT.getType());
        List<FictionInfo> fictionInfos = fictionInfoDao.selectByOrderType(param);
        Integer count = fictionInfoDao.selectByOrderTypeCount(param);
        int totalPage = count % 12 == 0 ? (count / 12) : count / 12 + 1;
        User loginUser = (User)generalConstants.mapCache.get(request.getKey());
        List<FictionInfoVO> vos = generateVO(fictionInfos,loginUser);
        return CommonResponse.successPage(vos, totalPage, request.getPage());
    }

    //点击榜
    @Override
    public CommonResponse getClickOrder(FictionRequest request) {
        Map<String, Object> param = new HashMap<>();
        param.put("start", (request.getPage() - 1) * 12);
        param.put("pageSize", 12);
        param.put("orderType", OrderTypeEnum.CLICK.getType());
        List<FictionInfo> fictionInfos = fictionInfoDao.selectByOrderType(param);
        Integer count = fictionInfoDao.selectByOrderTypeCount(param);
        int totalPage = count % 12 == 0 ? (count / 12) : count / 12 + 1;
        User loginUser = (User)generalConstants.mapCache.get(request.getKey());
        List<FictionInfoVO> vos = generateVO(fictionInfos,loginUser);
        return CommonResponse.successPage(vos, totalPage, request.getPage());
    }

    //喜欢榜
    @Override
    public CommonResponse getSubscriptionOrder(FictionRequest request) {
        Map<String, Object> param = new HashMap<>();
        param.put("start", (request.getPage() - 1) * 12);
        param.put("pageSize", 12);
        param.put("orderType", OrderTypeEnum.SUBSCRIPTION.getType());
        List<FictionInfo> fictionInfos = fictionInfoDao.selectByOrderType(param);
        Integer count = fictionInfoDao.selectByOrderTypeCount(param);
        int totalPage = count % 12 == 0 ? (count / 12) : count / 12 + 1;
        User loginUser = (User)generalConstants.mapCache.get(request.getKey());
        List<FictionInfoVO> vos = generateVO(fictionInfos,loginUser);
        return CommonResponse.successPage(vos, totalPage, request.getPage());
    }

    //男生榜
    @Override
    public CommonResponse male(FictionRequest request) {
        Map<String, Object> param = new HashMap<>();
        param.put("start", (request.getPage() - 1) * 12);
        param.put("pageSize", 12);
        param.put("sexType", SixTypeEnum.MALE.getType());
        List<FictionInfo> fictionInfos = fictionInfoDao.selectBySexType(param);
        Integer count = fictionInfoDao.selectBySexTypeCount(param);
        int totalPage = count % 12 == 0 ? (count / 12) : count / 12 + 1;
        User loginUser = (User)generalConstants.mapCache.get(request.getKey());
        List<FictionInfoVO> vos = generateVO(fictionInfos,loginUser);
        return CommonResponse.successPage(vos, totalPage, request.getPage());
    }

    //女生榜
    @Override
    public CommonResponse female(FictionRequest request) {
        Map<String, Object> param = new HashMap<>();
        param.put("start", (request.getPage() - 1) * 12);
        param.put("pageSize", 12);
        param.put("sexType", SixTypeEnum.FEMALE.getType());
        List<FictionInfo> fictionInfos = fictionInfoDao.selectBySexType(param);
        Integer count = fictionInfoDao.selectBySexTypeCount(param);
        int totalPage = count % 12 == 0 ? (count / 12) : count / 12 + 1;
        User loginUser = (User)generalConstants.mapCache.get(request.getKey());
        List<FictionInfoVO> vos = generateVO(fictionInfos,loginUser);
        return CommonResponse.successPage(vos, totalPage, request.getPage());
    }

    //都市
    @Override
    public CommonResponse romantic(FictionRequest request) {
        Map<String, Object> param = new HashMap<>();
        param.put("start", (request.getPage() - 1) * 12);
        param.put("pageSize", 12);
        param.put("fictionType", FictionTypeEnum.ROMANTIC.getType());
        List<FictionInfo> fictionInfos = fictionInfoDao.selectByFictionType(param);
        Integer count = fictionInfoDao.selectByFictionTypeCount(param);
        int totalPage = count % 12 == 0 ? (count / 12) : count / 12 + 1;
        User loginUser = (User)generalConstants.mapCache.get(request.getKey());
        List<FictionInfoVO> vos = generateVO(fictionInfos,loginUser);
        return CommonResponse.successPage(vos, totalPage, request.getPage());
    }

    //言情
    @Override
    public CommonResponse urban(FictionRequest request) {
        Map<String, Object> param = new HashMap<>();
        param.put("start", (request.getPage() - 1) * 12);
        param.put("pageSize", 12);
        param.put("fictionType", FictionTypeEnum.URBAN.getType());
        List<FictionInfo> fictionInfos = fictionInfoDao.selectByFictionType(param);
        Integer count = fictionInfoDao.selectByFictionTypeCount(param);
        int totalPage = count % 12 == 0 ? (count / 12) : count / 12 + 1;
        User loginUser = (User)generalConstants.mapCache.get(request.getKey());
        List<FictionInfoVO> vos = generateVO(fictionInfos,loginUser);
        return CommonResponse.successPage(vos, totalPage, request.getPage());
    }

    //小说详情
    @Override
    public CommonResponse detail(FictionRequest request) {
        if (request.getId() == null) {
            return CommonResponse.failure("参数错误！");
        }
        if (request.getRealPage() == null) {
            fictionInfoDao.addOrSubtract(OrderTypeEnum.CLICK.getType(), 1, request.getId());
        }
        FictionContentExample fictionContentExample = new FictionContentExample();
        fictionContentExample.createCriteria().andFictionIdEqualTo(request.getId());
        List<FictionContent> count = fictionContentMapper.selectByExampleWithBLOBs(fictionContentExample);
        if (CollectionUtils.isEmpty(count)) {
            return CommonResponse.failure("当前小说没有抓取详情，请联系管理员！");
        }
        fictionContentExample = new FictionContentExample();
        fictionContentExample.createCriteria().andFictionIdEqualTo(request.getId()).andPageEqualTo(request.getPage());
        List<FictionContent> fictionContentList = fictionContentMapper.selectByExampleWithBLOBs(fictionContentExample);
        int totalPage = count.size();
        return CommonResponse.successPage(fictionContentList.get(0) == null ? new FictionContent() : fictionContentList.get(0), totalPage, request.getPage());
    }

    //首页加载后内容
    @Override
    public CommonResponse afterLoad(FictionRequest request) {
        Map<String, Object> param = new HashMap<>();
        List<FictionInfo> fictionInfos = fictionInfoDao.afterLoad(param);
        User loginUser = (User)generalConstants.mapCache.get(request.getKey());
        List<FictionInfoVO> vos = generateVO(fictionInfos,loginUser);
        return CommonResponse.success(vos);
    }

    @Override
    public CommonResponse collect(FictionRequest request) {
        if (request.getId() == null || StringUtils.isBlank(request.getKey()) || request.getNum() == null) {
            return CommonResponse.failure("参数错误！");
        }
        User loginUser = (User) generalConstants.mapCache.get(request.getKey());
        String collectList = loginUser.getCollectList();
        List<String> list;
        if (StringUtils.isNotBlank(collectList)) {
            list = JSON.parseArray(collectList, String.class);
            if (request.getNum() == 1 && list.contains(request.getId().toString())) {
                return CommonResponse.failure("已经收藏,无法再次收藏");
            }
            if (request.getNum() == -1 && !list.contains(request.getId().toString())) {
                return CommonResponse.failure("还未收藏,不能取消收藏");
            }
        }else{
            if (request.getNum() == -1) {
                return CommonResponse.failure("还未收藏,不能取消收藏");
            }
            list = new ArrayList<>();
        }
        if(request.getNum() == 1){
            list.add(request.getId().toString());
        }
        if(request.getNum() == -1){
            list.remove(request.getId().toString());
        }
        User user = new User();
        user.setId(loginUser.getId());
        user.setUpdateTime(new Date());
        user.setCollectList(JSON.toJSONString(list));
        loginUser.setCollectList(JSON.toJSONString(list));
        userMapper.updateByPrimaryKeySelective(user);
        fictionInfoDao.addOrSubtract(OrderTypeEnum.COLLECT.getType(), request.getNum(), request.getId());
        return CommonResponse.success(true);
    }

    @Override
    public CommonResponse subscription(FictionRequest request) {
        if (request.getId() == null || StringUtils.isBlank(request.getKey()) || request.getNum() == null) {
            return CommonResponse.failure("参数错误！");
        }
        User loginUser = (User) generalConstants.mapCache.get(request.getKey());
        String subscriptionList = loginUser.getSubscriptionList();
        List<String> list;
        if (StringUtils.isNotBlank(subscriptionList)) {
            list = JSON.parseArray(subscriptionList, String.class);
            if (request.getNum() == 1 && list.contains(request.getId().toString())) {
                return CommonResponse.failure("已经喜欢,无法再次喜欢");
            }
            if (request.getNum() == -1 && !list.contains(request.getId().toString())) {
                return CommonResponse.failure("还未喜欢,不能取消喜欢");
            }
        }else{
            if (request.getNum() == -1) {
                return CommonResponse.failure("还未喜欢,不能取消喜欢");
            }
            list = new ArrayList<>();
        }
        if(request.getNum() == 1){
            list.add(request.getId().toString());
        }
        if(request.getNum() == -1){
            list.remove(request.getId().toString());
        }
        User user = new User();
        user.setId(loginUser.getId());
        user.setUpdateTime(new Date());
        user.setSubscriptionList(JSON.toJSONString(list));
        loginUser.setSubscriptionList(JSON.toJSONString(list));
        userMapper.updateByPrimaryKeySelective(user);
        fictionInfoDao.addOrSubtract(OrderTypeEnum.SUBSCRIPTION.getType(), request.getNum(), request.getId());
        return CommonResponse.success(true);
    }
}
