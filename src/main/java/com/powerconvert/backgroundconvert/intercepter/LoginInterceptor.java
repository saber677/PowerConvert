package com.powerconvert.backgroundconvert.intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Boolean isLogin = (Boolean) request.getSession().getAttribute(SessionConstant.USER_LOGIN_STATUS);
//        logger.info("开始拦截,是否通过拦截:{}", (!Objects.isNull(isLogin) && isLogin));
        return true;
//        String accountId = request.getHeader(SessionConstant.USER_AUTH);
//        String token = request.getSession().getAttribute(SessionConstant.USER_AUTH).toString();
//        if (StringUtils.isNotEmpty(accountId) && StringUtils.equals(accountId, token)) {
//            UserContextUtil.setAccountId(Long.parseLong(accountId));
//            return true;
//        } else {
//            return true;
//        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }



}
