package com.trumpeted.stone.manage.web.home.Dto;

import lombok.Data;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.Serializable;

/**
 * Author: 梁启富
 * Date: 2019-03-07 15:51
 * Description: <描述>
 */
@Data
public class StoneDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String image;

    private CommonsMultipartFile file;
    private Integer stoneTypeId;

}
