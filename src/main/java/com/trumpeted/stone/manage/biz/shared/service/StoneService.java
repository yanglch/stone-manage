/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.biz.shared.service;

import com.trumpeted.stone.manage.biz.shared.vo.StoneVo;
import com.trumpeted.stone.manage.common.dal.dataobject.StoneDo;
import com.trumpeted.stone.manage.web.home.Dto.StoneDto;

import java.util.List;

/**
 *
 * @author ylc
 * @version $Id: StoneService.java, v 0.1 2019年03月05日 2:06 ylc Exp $
 */
public interface StoneService {

    /**
     * 根据类型code查询石材
     * @param typeCode
     * @return
     */
    List<StoneVo> queryByTypeCode(String typeCode);

    /**
     * 添加产品
     */
    void add(StoneDto stoneDto);

    /**
     * 修改产品
     */
    void update(StoneVo stoneVo);


    /**
     * 查询所有石材类型
     */
    List<StoneDo> selectAll();

    StoneDo findById(int id);

    boolean checkName(String name);

}