/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.biz.shared.service.impl;

import com.trumpeted.stone.manage.biz.shared.service.FileUploadService;
import com.trumpeted.stone.manage.biz.shared.vo.FileUploadResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 *
 * @author ylc
 * @version $Id: FileUploadServiceImpl.java, v 0.1 2019年03月07日 2:07 ylc Exp $
 */
@Service
@ConfigurationProperties(prefix = "stone.upload")
@Validated
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

    @NotNull
    private String uploadCatalog;

    @Override
    public FileUploadResult upload(MultipartFile file) {
        Assert.notNull(file, "file is not be null");
        FileUploadResult result = new FileUploadResult();
        try {
            String fileName = file.getOriginalFilename();
            Assert.hasText(fileName, "file name is be empty");
            int index = fileName.lastIndexOf(".");
            if(index == -1){
                result.setSuccess(false);
                result.setFailMsg("文件无后缀名");
                return result;
            }
            fileName = UUID.randomUUID().toString() + fileName.substring(index);
            file.transferTo(new File(uploadCatalog + fileName));
            result.setSuccess(true);
            result.setFileCatalog(fileName);
        } catch (IOException e) {
            log.error("upload file is fail", e);
        }
        return result;
    }

    public String getUploadCatalog() {
        return uploadCatalog;
    }

    public void setUploadCatalog(String uploadCatalog) {
        this.uploadCatalog = uploadCatalog;
    }
}