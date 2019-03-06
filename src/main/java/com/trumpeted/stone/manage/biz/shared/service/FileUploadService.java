/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.biz.shared.service;

import com.trumpeted.stone.manage.biz.shared.vo.FileUploadResult;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ylc
 * @version $Id: FileUploadService.java, v 0.1 2019年03月07日 2:02 ylc Exp $
 */
public interface FileUploadService {


    FileUploadResult upload(MultipartFile file);
}