/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.web.home.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trumpeted.stone.manage.biz.shared.Exception.StoneTypeException;
import com.trumpeted.stone.manage.biz.shared.constant.PaginationConstant;
import com.trumpeted.stone.manage.biz.shared.constant.ResponseStatusConstant;
import com.trumpeted.stone.manage.biz.shared.convert.CommonConvert;
import com.trumpeted.stone.manage.biz.shared.service.StoneTypeService;
import com.trumpeted.stone.manage.biz.shared.vo.StoneTypeVo;
import com.trumpeted.stone.manage.common.dal.dataobject.StoneTypeDo;
import com.trumpeted.stone.manage.utils.ResponseResult;
import com.trumpeted.stone.manage.web.home.model.StoneTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * @author ylc
 * @version $Id: TestController.java, v 0.1 2019年03月05日 2:19 ylc Exp $
 */
@Controller
@RequestMapping("/stone/type/")
public class StoneTypeController<commonResult> {

    @Autowired
    private StoneTypeService stoneTypeService;

    @GetMapping("/query_all")
    @ResponseBody
    public Object queryAll(){

        return stoneTypeService.queryAll();
    }

    @PostMapping("insert")
    @ResponseBody
    public ResponseResult add(String name){
        ResponseResult result = new ResponseResult();

        try {
            stoneTypeService.add(name);
            result.setStatus(ResponseStatusConstant.STONE_STATUS_SUCCESS);
            result.setMessage("添加成功");
        } catch (Exception e) {
            result.setStatus(ResponseStatusConstant.STONE_STATUS_FAIL);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }

        return result;

    }

    @PostMapping("update")
    @ResponseBody
    public Object update(StoneTypeModel stoneTypeModel){
        stoneTypeService.update(CommonConvert.toVo(stoneTypeModel, StoneTypeVo.class));
        return null;
    }

    @GetMapping("/view.htm")
    public String view(Integer pagNum,Model model){
        if(ObjectUtils.isEmpty(pagNum)){
            pagNum= PaginationConstant.PAGE_NUM;
        }
        PageHelper.startPage(pagNum,PaginationConstant.PAGE_SIZE);
        List<StoneTypeVo> stoneTypeVos = stoneTypeService.findAll();

        PageInfo<StoneTypeVo> pageInfo = new PageInfo<>(stoneTypeVos);
        model.addAttribute("pageInfo",pageInfo);

        return "stoneType/stoneTypeList";
    }

    @PostMapping("findById")
    @ResponseBody
    public ResponseResult findById(int id){
        StoneTypeDo stoneTypeDo=  stoneTypeService.findById(id);
        return ResponseResult.success(stoneTypeDo);
    }
    @PostMapping("modifyName")
    @ResponseBody
    public ResponseResult modifyName(int id,String name){
        try {
            stoneTypeService.modifyName(id,name);
            return ResponseResult.success("修改石材类型成功");
        } catch (StoneTypeException e) {
            //e.printStackTrace();
            return ResponseResult.success(e.getMessage());
        }
    }

    @GetMapping("modifyStatus")
    @ResponseBody
    public ResponseResult modifyStatus(int id){
        stoneTypeService.modifyStatus(id);

        return ResponseResult.success();
    }
}