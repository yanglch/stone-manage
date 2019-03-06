/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.biz.shared.service.impl;

import com.trumpeted.stone.manage.biz.shared.convert.CommonConvert;
import com.trumpeted.stone.manage.biz.shared.service.StoneService;
import com.trumpeted.stone.manage.biz.shared.vo.StoneVo;
import com.trumpeted.stone.manage.common.dal.dao.StoneDao;
import com.trumpeted.stone.manage.common.dal.dataobject.StoneDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 *
 * @author ylc
 * @version $Id: StoneServiceImpl.java, v 0.1 2019年03月05日 2:06 ylc Exp $
 */
@Service
public class StoneServiceImpl implements StoneService {

    @Autowired
    private StoneDao stoneDao;

    @Override
    public List<StoneVo> queryByTypeCode(String typeCode) {
        return CommonConvert.toVoList(stoneDao.findByTypeCode(typeCode), StoneVo.class);
    }

    @Override
    public void add(StoneVo stoneVo) {
        Assert.notNull(stoneVo, "stoneVo cannot be null");
        StoneDo stoneDo = CommonConvert.toDo(stoneVo, StoneDo.class);
        stoneDao.insert(stoneDo);
    }

    @Override
    public void update(StoneVo stoneVo) {
        Assert.notNull(stoneVo, "stoneVo cannot be null");
        StoneDo stoneDo = CommonConvert.toDo(stoneVo, StoneDo.class);
        stoneDao.updateById(stoneDo);
    }

    @Override
    public List<StoneVo> selectAll() {


        return CommonConvert.toVoList(stoneDao.selectAll(), StoneVo.class);
    }


}