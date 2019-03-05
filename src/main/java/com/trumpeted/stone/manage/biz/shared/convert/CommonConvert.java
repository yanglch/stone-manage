/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.biz.shared.convert;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ylc
 * @version $Id: CommonConvert.java, v 0.1 2019年03月05日 2:38 ylc Exp $
 */
@Slf4j
public class CommonConvert {


    public static <D, V> List<V> toVoList(List<D> doList, Class<V> voClass){
        Assert.notNull(doList, "do list can not be null");
        final List<V> voList = new ArrayList<>(doList.size());
        doList.forEach((data) -> {
            V vo = BeanUtils.instantiateClass(voClass);
            BeanUtils.copyProperties(data, vo);
            voList.add(vo);
        });
        return voList;
    }

    public static <D, V> D toDo(V vo, Class<D> doClass){
        return convert(vo, doClass);
    }

    public static <D, V> D toVo(V model, Class<D> voClass){
        return convert(model, voClass);
    }

    private static <D, V> D convert(V vo, Class<D> doClass){
        if(vo == null){
            return null;
        }
        D doObj = BeanUtils.instantiateClass(doClass);
        BeanUtils.copyProperties(vo, doObj);
        return doObj;
    }
}