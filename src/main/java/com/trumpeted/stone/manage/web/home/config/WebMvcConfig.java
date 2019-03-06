/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.web.home.config;

import com.trumpeted.stone.manage.web.home.interceptor.MvcTemplateInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author ylc
 * @version $Id: WebMvcConfig.java, v 0.1 2019年03月05日 1:01 ylc Exp $
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

    @Autowired
    private MvcTemplateInterceptor mvcTemplateInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mvcTemplateInterceptor).addPathPatterns("/**/*.htm");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}