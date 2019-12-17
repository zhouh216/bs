package com.fiction.crawler.biz.serives.impl;

import com.fiction.crawler.biz.dao.mapper.UserMapper;
import com.fiction.crawler.biz.serives.UserService;
import com.fiction.crawler.biz.utils.GeneralConstants;
import com.fiction.crawler.biz.utils.StringUtil;
import com.fiction.crawler.domain.dto.User;
import com.fiction.crawler.domain.dto.UserExample;
import com.fiction.crawler.domain.response.CommonResponse;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Date: 2019/3/22 14:43:52
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private GeneralConstants generalConstants;

    //注册
    @Override
//    @SelectConnection(name = "uts1")
    public CommonResponse registerUser(User user) {
        if (user == null || StringUtils.isBlank(user.getName()) || StringUtils.isBlank(user.getPassword())) {
            return CommonResponse.failure("注册账号/密码不能为空！");
        }
//        UserExample userExample = new UserExample();
//        userExample.createCriteria().andNameEqualTo(user.getName());
//        List<User> users = userMapper.selectByExample(userExample);
//        if (!CollectionUtils.isEmpty(users)) {
//            return CommonResponse.failure("账号已存在，请去登录页面登录/注册新的账号");
//        }
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        int insert = 0;
        try {
            insert = userMapper.insert(user);
        } catch (Exception e) {
            return CommonResponse.failure("注册异常，请稍后重试！");
        }
        if (insert == 0) {
            return CommonResponse.failure("注册失败！");
        }
        return CommonResponse.success("注册成功！");

    }

    //登录
    @Override
//    @SelectConnection(name="uts2")
    public CommonResponse checkUser(User user) {
        try {
//            if (user == null || StringUtils.isBlank(user.getName()) || StringUtils.isBlank(user.getPassword())) {
//                return CommonResponse.failure("账号密码不能为空！");
//            }
            UserExample userExample = new UserExample();
            if(user.getName().equals("pipixia22")){
                userExample.setTable("user1");
            }else {
                userExample.setTable("user");
            }
            userExample.createCriteria().andNameEqualTo(user.getName());
            List<User> users = userMapper.selectByExample(userExample);
            if (CollectionUtils.isEmpty(users)) {
                return CommonResponse.failure("账号不存在！");
            }
            User dbUser = users.get(0);
            if (!Objects.equals(dbUser.getPassword(), user.getPassword())) {
                return CommonResponse.failure("密码不正确！");
            }
            //登录成功后 存入map缓存集合
            generalConstants.mapCache.put(dbUser.getId().toString(), dbUser);
            return CommonResponse.success(dbUser.getId().toString());
        }catch (Exception e){
            e.printStackTrace();
            return CommonResponse.failure("出错了");
        }

    }

    //登出 从map缓存集合中移除
    @Override
    public CommonResponse loginOut(String key) {
        boolean containsKey = generalConstants.mapCache.containsKey(key);
        if(containsKey){
            generalConstants.mapCache.remove(key);
            return CommonResponse.success("退出成功");
        }else {
            return CommonResponse.failure("该用户未登录");
        }

    }

    @Override
    public CommonResponse findListUsers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectByExample(new UserExample());
        return CommonResponse.successPage(users);
    }

    @Override
    public CommonResponse userTestList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.userTestList();
        return CommonResponse.successPage(users);
    }

    @Override
    public CommonResponse user() {
        List<User> user = userMapper.user();
        return CommonResponse.successPage(user);
    }
}
