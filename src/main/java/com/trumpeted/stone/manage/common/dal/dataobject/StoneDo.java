/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.common.dal.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ylc
 * @version $Id: StoneDo.java, v 0.1 2019年03月05日 1:52 ylc Exp $
 */
@Data
public class StoneDo implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private String name;

    private Long typeId;

    private Date gmtModifier;

    private Date gmtCreated;
}