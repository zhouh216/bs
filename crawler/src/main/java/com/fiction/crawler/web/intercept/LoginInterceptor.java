
package com.fiction.crawler.web.intercept;

import com.fiction.crawler.biz.utils.GeneralConstants;
import com.fiction.crawler.domain.dto.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

//用户登录拦截器
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private GeneralConstants generalConstants;

    //判断用户请求是否携带key
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String key = request.getParameter("key");
        if(StringUtils.isNotBlank(key)){
            User user = (User)generalConstants.mapCache.get(key.toString());
            if(user != null && Objects.equals(user.getId().toString(),key)){
                return true;
            }
        }
        response.sendRedirect(request.getContextPath()+"/login");
        return false;
    }

}
