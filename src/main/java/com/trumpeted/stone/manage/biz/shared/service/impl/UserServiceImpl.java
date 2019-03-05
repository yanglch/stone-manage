/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.biz.shared.service.impl;

import com.trumpeted.stone.manage.biz.shared.convert.CommonConvert;
import com.trumpeted.stone.manage.biz.shared.service.UserService;
import com.trumpeted.stone.manage.biz.shared.vo.UserVo;
import com.trumpeted.stone.manage.common.dal.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 *
 * @author ylc
 * @version $Id: UserServiceImpl.java, v 0.1 2019年03月04日 23:55 ylc Exp $
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public UserVo getUser(String loginName) {
        Assert.hasText(loginName, "login name can not empty");
        return CommonConvert.toVo(sysUserDao.findByLoginName(loginName), UserVo.class);
    }
}