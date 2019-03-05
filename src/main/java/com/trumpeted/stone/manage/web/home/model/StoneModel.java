/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.web.home.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ylc
 * @version $Id: StoneModel.java, v 0.1 2019年03月05日 3:31 ylc Exp $
 */
@Data
public class StoneModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long typeId;

    private String name;

    private Date gmtModifier;

    private Date gmtCreated;
}