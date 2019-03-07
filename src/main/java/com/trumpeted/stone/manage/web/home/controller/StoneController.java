/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.web.home.controller;

import com.trumpeted.stone.manage.biz.shared.convert.CommonConvert;
import com.trumpeted.stone.manage.biz.shared.service.FileUploadService;
import com.trumpeted.stone.manage.biz.shared.service.StoneService;
import com.trumpeted.stone.manage.biz.shared.service.StoneTypeService;
import com.trumpeted.stone.manage.biz.shared.vo.FileUploadResult;
import com.trumpeted.stone.manage.biz.shared.vo.StoneVo;
import com.trumpeted.stone.manage.common.dal.dataobject.StoneDo;
import com.trumpeted.stone.manage.utils.ResponseResult;
import com.trumpeted.stone.manage.web.home.Dto.StoneDto;
import com.trumpeted.stone.manage.web.home.model.StoneModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private StoneTypeService stoneTypeService;
    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("query/{code}")
    @ResponseBody
    public Object queryCode(@PathVariable String code){

        return stoneService.queryByTypeCode(code);
    }

    @PostMapping("add")
    @ResponseBody
    public ResponseResult add(StoneDto stoneDto, @RequestParam(value = "file", required = false)MultipartFile file){
        FileUploadResult upload = fileUploadService.upload(file);
        String fileCatalog = upload.getFileCatalog();
        stoneDto.setImage(fileCatalog);
        stoneService.add(stoneDto);
        return ResponseResult.success();
    }

    @PostMapping("update")
    @ResponseBody
    public Object update(StoneDto stoneDto, @RequestParam(value = "file2", required = false)MultipartFile file){
        FileUploadResult upload = fileUploadService.upload(file);
        String fileCatalog = upload.getFileCatalog();
        stoneDto.setImage(fileCatalog);
        stoneService.update(CommonConvert.toVo(stoneDto, StoneVo.class));
        return ResponseResult.success();
    }


    @GetMapping("view.htm")
    public String view(Model model){
        List<StoneDo> stoneVoList = stoneService.selectAll();
        model.addAttribute("stoneVoList",stoneVoList);
        return "stone/stoneList";
    }

    @ModelAttribute("StoneTypeDos")
    public List<StoneDo> loadStoneTypes(){
        List<StoneDo> stoneDos=stoneTypeService.findEnable();
        return stoneDos;
    }
    @PostMapping("findById")
    @ResponseBody
    public ResponseResult findById(int id){
        StoneDo byId = stoneService.findById(id);

        return ResponseResult.success(byId);
    }
    @PostMapping("checkName")
    @ResponseBody
    public Map<String,Object> checkName(String name){
        HashMap<String, Object> map = new HashMap<>();
        if (stoneService.checkName(name)){
            map.put("valid",true);
        }else {
            map.put("valid",false);
            map.put("message","该石材类型《"+name+"》已存在");
        }
        return map;
    }

}