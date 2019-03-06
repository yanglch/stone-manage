/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.biz.shared.vo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ylc
 * @version $Id: FileUploadResult.java, v 0.1 2019年03月07日 2:04 ylc Exp $
 */
@Getter
@Setter
public class FileUploadResult {

    /** 是否上次成功 **/
    private boolean success;

    /** 上传的目录 **/
    private String fileCatalog;

    /** 失败原因 **/
    private String failMsg;
}