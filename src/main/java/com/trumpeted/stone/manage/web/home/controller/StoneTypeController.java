/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.web.home.controller;

import com.trumpeted.stone.manage.biz.shared.convert.CommonConvert;
import com.trumpeted.stone.manage.biz.shared.service.StoneTypeService;
import com.trumpeted.stone.manage.biz.shared.vo.StoneTypeVo;
import com.trumpeted.stone.manage.web.home.model.StoneTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ylc
 * @version $Id: TestController.java, v 0.1 2019年03月05日 2:19 ylc Exp $
 */
@Controller
@RequestMapping("/stone/type/")
public class StoneTypeController {

    @Autowired
    private StoneTypeService stoneTypeService;

    @GetMapping("/query_all")
    @ResponseBody
    public Object queryAll(){

        return stoneTypeService.queryAll();
    }

    @PostMapping("insert")
    @ResponseBody
    public Object add(StoneTypeModel stoneTypeModel){
        stoneTypeService.add(CommonConvert.toVo(stoneTypeModel, StoneTypeVo.class));

        return null;
    }

    @PostMapping("update")
    @ResponseBody
    public Object update(StoneTypeModel stoneTypeModel){
        stoneTypeService.update(CommonConvert.toVo(stoneTypeModel, StoneTypeVo.class));
        return null;
    }

    @GetMapping("/view.htm")
    public String view(){

        return "";//TODO 产品类型页面
    }


}