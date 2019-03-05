/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.web.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ylc
 * @version $Id: IndexController.java, v 0.1 2019年03月05日 20:44 ylc Exp $
 */

@Controller
public class IndexController {


    @GetMapping("login.htm")
    public String login(){
        return "common/login";
    }


}