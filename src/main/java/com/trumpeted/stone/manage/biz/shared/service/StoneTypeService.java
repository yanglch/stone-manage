/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.biz.shared.service;

import com.trumpeted.stone.manage.biz.shared.Exception.StoneTypeException;
import com.trumpeted.stone.manage.biz.shared.vo.StoneTypeVo;
import com.trumpeted.stone.manage.common.dal.dataobject.StoneTypeDo;

import java.util.List;

/**
 *
 * @author ylc
 * @version $Id: StoneTypeService.java, v 0.1 2019年03月05日 2:05 ylc Exp $
 */
public interface StoneTypeService {

    /**
     * 查询所有石材类型
     * @return
     */
    List<StoneTypeVo> queryAll();

    /**
     * 添加产品类型
     */
    void add(String name) throws StoneTypeException;

    /**
     * 修改产品类型
     */
    void update(StoneTypeVo stoneTypeVo);

    List<StoneTypeVo> findAll();

    StoneTypeDo findById(int id);

    void modifyName(int id, String name) throws StoneTypeException;

    void modifyStatus(int id);
}