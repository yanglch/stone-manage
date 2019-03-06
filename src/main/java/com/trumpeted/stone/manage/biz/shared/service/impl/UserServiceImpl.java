/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.biz.shared.service.impl;

import com.trumpeted.stone.manage.biz.shared.convert.CommonConvert;
import com.trumpeted.stone.manage.biz.shared.service.UserService;
import com.trumpeted.stone.manage.biz.shared.vo.UserVo;
import com.trumpeted.stone.manage.common.dal.dao.SysUserDao;
import com.trumpeted.stone.manage.common.dal.dataobject.SysUserDo;
import com.trumpeted.stone.manage.common.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 *
 * @author ylc
 * @version $Id: UserServiceImpl.java, v 0.1 2019年03月04日 23:55 ylc Exp $
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserVo getUser(String loginName) {
        Assert.hasText(loginName, "login name can not empty");
        return CommonConvert.toVo(sysUserDao.findByLoginName(loginName), UserVo.class);
    }

    @Override
    public List<UserVo> getUserAll() {
        return CommonConvert.toVoList(sysUserDao.findByPage(0, 100), UserVo.class);
    }

    @Override
    public CommonResult addUser(UserVo userVo) {
        Assert.notNull(userVo, "user vo is not be null");
        Assert.hasText(userVo.getLoginName(), "login name is not be empty");
        Assert.hasText(userVo.getPassWord(), "password is not be empty");
        if(getUser(userVo.getLoginName()) != null){
            return new CommonResult("系统中已存在相同的登陆名", false);
        }

        String passWord = bCryptPasswordEncoder.encode(userVo.getPassWord());
        userVo.setPassWord(passWord);
        sysUserDao.insert(CommonConvert.toDo(userVo, SysUserDo.class));
        return new CommonResult(true);
    }

    @Override
    public CommonResult deleteUser(long userID) {
        return new CommonResult(sysUserDao.delete(userID) == 1);
    }
}