/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.biz.shared.service;

import com.trumpeted.stone.manage.biz.shared.vo.UserVo;
import com.trumpeted.stone.manage.common.utils.CommonResult;

import java.util.List;

/**
 *
 * @author ylc
 * @version $Id: UserServiceImpl.java, v 0.1 2019年03月04日 23:55 ylc Exp $
 */
public interface UserService {

    /**
     * 根据登录名获取用户
     * @param loginName
     * @return
     */
    UserVo getUser(String loginName);

    /**
     * 查询所有用户
     * @return
     */
    List<UserVo> getUserAll();

    /**
     * 新增用户
     * @param userVo
     * @return
     */
    CommonResult addUser(UserVo userVo);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    CommonResult deleteUser(long userId);

}