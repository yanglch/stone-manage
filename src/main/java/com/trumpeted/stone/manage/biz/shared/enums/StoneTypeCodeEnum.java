///**
// * Alipay.com Inc.
// * Copyright (c) 2004-2019 All Rights Reserved.
// */
//package com.trumpeted.stone.manage.biz.shared.enums;
//
//import org.springframework.util.StringUtils;
//
///**
// *
// */
//public enum StoneTypeCodeEnum {
//
//    GRIOTTE("GRIOTTE", "大理石"),
//    QUARTZITE("QUARTZITE", "石英石");
//    private String code;
//    private String desc;
//
//    StoneTypeCodeEnum(String code, String desc) {
//        this.code = code;
//        this.desc = desc;
//    }
//
//    public static StoneTypeCodeEnum byCode(String code){
//        if(!StringUtils.hasText(code)){
//            return null;
//        }
//        for(StoneTypeCodeEnum stoneTypeCodeEnum : values()){
//            if(code.equals(stoneTypeCodeEnum.getCode())){
//                return stoneTypeCodeEnum;
//            }
//        }
//        return null;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
//}