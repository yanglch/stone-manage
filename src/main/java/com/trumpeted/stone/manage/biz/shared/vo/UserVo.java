/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.biz.shared.vo;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author ylc
 * @version $Id: UserVo.java, v 0.1 2019年03月04日 23:56 ylc Exp $
 */
@Data
public class UserVo {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String realName;

    private String loginName;

    private String passWord;

    private String salt;

    private String roleId;

    private String permissionId;

    private Date gmtModifier;

    private Date gmtCreated;
}