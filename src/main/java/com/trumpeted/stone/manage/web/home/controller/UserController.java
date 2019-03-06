/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.web.home.controller;

import com.trumpeted.stone.manage.biz.shared.convert.CommonConvert;
import com.trumpeted.stone.manage.biz.shared.service.FileUploadService;
import com.trumpeted.stone.manage.biz.shared.service.UserService;
import com.trumpeted.stone.manage.biz.shared.vo.UserVo;
import com.trumpeted.stone.manage.web.home.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ylc
 * @version $Id: UserController.java, v 0.1 2019年02月28日 1:17 ylc Exp $
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("query/{id}")
    @ResponseBody
    public Object queryById(@PathVariable("id") int id){
        return  null;
    }

    @GetMapping("page/{startNo}/{pageSize}")
    @ResponseBody
    public Object page(@PathVariable("startNo")String startNo, @PathVariable("pageSize")String pageSize){
        return null;
    }

    @PostMapping("update")
    @ResponseBody
    public Object update(UserModel user){
        return null;
    }

    @PostMapping("delete")
    @ResponseBody
    public Object delete(long userId){
        return userService.deleteUser(userId);
    }

    @PostMapping("insert")
    @ResponseBody
    public Object insert(UserModel user){
        return userService.addUser(CommonConvert.toVo(user, UserVo.class));
    }

    @GetMapping("view.htm")
    public String view(Model model){
        model.addAttribute("userList", userService.getUserAll());
        return "sys/user/userList";
    }


    @Autowired
    private FileUploadService fileUploadService;

}