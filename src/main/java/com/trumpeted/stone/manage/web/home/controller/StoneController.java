/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.web.home.controller;

import com.trumpeted.stone.manage.biz.shared.convert.CommonConvert;
import com.trumpeted.stone.manage.biz.shared.service.StoneService;
import com.trumpeted.stone.manage.biz.shared.vo.StoneVo;
import com.trumpeted.stone.manage.web.home.model.StoneModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author ylc
 * @version $Id: StoneController.java, v 0.1 2019年03月05日 3:03 ylc Exp $
 */
@Controller
@RequestMapping("/stone/")
public class StoneController {

    @Autowired
    private StoneService stoneService;

    @GetMapping("query/{code}")
    @ResponseBody
    public Object queryCode(@PathVariable String code){
        return stoneService.queryByTypeCode(code);
    }

    @PostMapping("insert")
    @ResponseBody
    public Object add(StoneModel stoneModel){
        stoneService.add(CommonConvert.toVo(stoneModel, StoneVo.class));
        return null;
    }

    @PostMapping("update")
    @ResponseBody
    public Object update(StoneModel stoneModel){
        stoneService.update(CommonConvert.toVo(stoneModel, StoneVo.class));
        return null;
    }


    @GetMapping("view.htm")
    public String view(Model model){
        List<StoneVo> stoneVoList = stoneService.selectAll();
        model.addAttribute("stoneVoList",stoneVoList);
        return "stone/stoneList";
    }
}