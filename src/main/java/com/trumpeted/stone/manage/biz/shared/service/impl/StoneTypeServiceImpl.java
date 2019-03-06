/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.biz.shared.service.impl;

import com.trumpeted.stone.manage.biz.shared.Exception.StoneTypeException;
import com.trumpeted.stone.manage.biz.shared.constant.StoneTypeConstant;
import com.trumpeted.stone.manage.biz.shared.convert.CommonConvert;
import com.trumpeted.stone.manage.biz.shared.service.StoneTypeService;
import com.trumpeted.stone.manage.biz.shared.vo.StoneTypeVo;
import com.trumpeted.stone.manage.common.dal.dao.StoneTypeDao;
import com.trumpeted.stone.manage.common.dal.dataobject.StoneTypeDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
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
    public void add(String name) throws StoneTypeException {
        Assert.hasText(name, "stoneTypeVo cannot be null");
        StoneTypeDo stoneType1 = stoneTypeDao.selectByName(name);
        if (stoneType1 != null) {
            throw new StoneTypeException("石材类型已存在");
        }
        StoneTypeDo stoneTypeDo = new StoneTypeDo();
        stoneTypeDo.setName(name);
        stoneTypeDo.setStatus(StoneTypeConstant.Stone_TYPE_ENALE);
        stoneTypeDao.insert(stoneTypeDo);
    }

    @Override
    public void update(StoneTypeVo stoneTypeVo) {
        Assert.notNull(stoneTypeVo, "stoneTypeVo cannot be null");
        StoneTypeDo stoneTypeDo = CommonConvert.toDo(stoneTypeVo, StoneTypeDo.class);
        stoneTypeDao.updateById(stoneTypeDo);
    }

    @Override
    public List<StoneTypeVo> findAll() {


        return stoneTypeDao.selectAll();
    }

    @Override
    public StoneTypeDo findById(int id) {

        return stoneTypeDao.selectById(id);
    }

    @Override
    public void modifyName(int id, String name) throws StoneTypeException {
        StoneTypeDo stoneTypeDo = stoneTypeDao.selectByName(name);
        if (stoneTypeDo != null) {
            throw new StoneTypeException("该石材类型已存在");
        }
        stoneTypeDao.updateName(id, name);
    }

    @Override
    public void modifyStatus(int id) {
        StoneTypeDo byId = findById(id);
        int status = byId.getStatus();
        if (status == StoneTypeConstant.Stone_TYPE_ENALE) {
            status = StoneTypeConstant.Stone_TYPE_DISABLE;
        } else {
            status = StoneTypeConstant.Stone_TYPE_ENALE;
        }
        stoneTypeDao.updateStatus(id, status);
    }
}