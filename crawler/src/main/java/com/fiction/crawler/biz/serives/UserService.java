package com.fiction.crawler.biz.serives;


import com.fiction.crawler.domain.dto.User;
import com.fiction.crawler.domain.response.CommonResponse;

/**
 * @Date: 2019/3/22 14:43:32
 */
public interface UserService {

    CommonResponse registerUser(User user);

    CommonResponse checkUser(User user);

    CommonResponse loginOut(String key);

    CommonResponse findListUsers(int pageNum, int pageSize);

    CommonResponse userTestList(Integer pageNum, Integer pageSize);

    CommonResponse user();
}
