/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.web.home.controller;

import com.trumpeted.stone.manage.biz.shared.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author ylc
 * @version $Id: IndexController.java, v 0.1 2019年03月05日 20:44 ylc Exp $
 */

@Controller
public class IndexController {

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("login.htm")
    public String login(){
        return "common/login";
    }

    @GetMapping("image/{imageName}")
    public void image(HttpServletResponse response, @PathVariable String imageName) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=\"" + imageName + "\"");
        response.setContentType("application/octet-stream;charset=UTF-8");
        fileUploadService.flushFile(imageName, response.getOutputStream());
    }

}