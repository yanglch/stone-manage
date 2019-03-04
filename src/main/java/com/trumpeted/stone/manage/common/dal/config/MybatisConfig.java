/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.common.dal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ylc
 * @version $Id: MybatisConfig.java, v 0.1 2019年02月28日 1:29 ylc Exp $
 */
@Configuration
@MapperScan("com.trumpeted.stone.manage.common.dal.dao")
public class MybatisConfig {

}