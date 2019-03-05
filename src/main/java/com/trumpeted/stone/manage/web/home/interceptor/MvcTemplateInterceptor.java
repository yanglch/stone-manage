/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.web.home.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ylc
 * @version $Id: MvcTemplateInterceptor.java, v 0.1 2019年03月05日 1:02 ylc Exp $
 */
@Component
public class MvcTemplateInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView)
            throws Exception {
        if(request.getRequestURL() != null && request.getRequestURL().toString().endsWith("login.htm")){
            return;
        }
        request.setAttribute("viewName", modelAndView.getViewName());
        modelAndView.setViewName("index");
    }
}