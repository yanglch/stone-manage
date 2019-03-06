/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.web.home.model;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author ylc
 * @version $Id: UserModel.java, v 0.1 2019年03月05日 0:05 ylc Exp $
 */
@Data
public class UserModel {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String realName;

    private String loginName;

    private String passWord;

    private String roleId;

    private String permissionId;

    private Date gmtModifier;
}