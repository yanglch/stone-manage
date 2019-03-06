/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.common.utils;

/**
 *
 * @author ylc
 * @version $Id: CommonResult.java, v 0.1 2019年03月07日 1:39 ylc Exp $
 */
public class CommonResult {

    private String msg;

    private boolean success;

    private Object data;

    public CommonResult() {}

    public CommonResult(boolean success) {
        this.success = success;
    }

    public CommonResult(String msg, boolean success) {
        this.msg = msg;
        this.success = success;
    }

    public CommonResult(String msg, boolean success, Object data) {
        this.msg = msg;
        this.success = success;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}