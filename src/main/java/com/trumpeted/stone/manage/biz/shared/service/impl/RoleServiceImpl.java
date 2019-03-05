/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.biz.shared.service.impl;

import com.trumpeted.stone.manage.biz.shared.convert.CommonConvert;
import com.trumpeted.stone.manage.biz.shared.service.RoleService;
import com.trumpeted.stone.manage.biz.shared.vo.RoleVo;
import com.trumpeted.stone.manage.common.dal.dao.SysRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ylc
 * @version $Id: RoleServiceImpl.java, v 0.1 2019年03月04日 23:55 ylc Exp $
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public RoleVo getRole(long roleId) {
        return CommonConvert.toVo(sysRoleDao.findById(roleId), RoleVo.class);
    }

}