/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.biz.shared.service.impl;

import com.trumpeted.stone.manage.biz.shared.convert.CommonConvert;
import com.trumpeted.stone.manage.biz.shared.service.StoneTypeService;
import com.trumpeted.stone.manage.biz.shared.vo.StoneTypeVo;
import com.trumpeted.stone.manage.common.dal.dao.StoneTypeDao;
import com.trumpeted.stone.manage.common.dal.dataobject.StoneDo;
import com.trumpeted.stone.manage.common.dal.dataobject.StoneTypeDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 *
 * @author ylc
 * @version $Id: StoneTypeServiceImpl.java, v 0.1 2019年03月05日 2:06 ylc Exp $
 */
@Service
public class StoneTypeServiceImpl implements StoneTypeService {

    @Autowired
    private StoneTypeDao stoneTypeDao;

    @Override
    public List<StoneTypeVo> queryAll() {
        return CommonConvert.toVoList(stoneTypeDao.findByPage(0, 999), StoneTypeVo.class);
    }

    @Override
    public void add(StoneTypeVo stoneTypeVo) {
        Assert.notNull(stoneTypeVo, "stoneTypeVo cannot be null");
        StoneTypeDo stoneTypeDo = CommonConvert.toDo(stoneTypeVo, StoneTypeDo.class);
        stoneTypeDao.insert(stoneTypeDo);
    }

    @Override
    public void update(StoneTypeVo stoneTypeVo) {
        Assert.notNull(stoneTypeVo, "stoneTypeVo cannot be null");
        StoneTypeDo stoneTypeDo = CommonConvert.toDo(stoneTypeVo, StoneTypeDo.class);
        stoneTypeDao.updateById(stoneTypeDo);
    }
}