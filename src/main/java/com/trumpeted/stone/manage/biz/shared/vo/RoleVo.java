package com.trumpeted.stone.manage.biz.shared.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author ylc
 * @since 2019-02-28
 */
@Data
public class RoleVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String userId;

    private String permissionId;

    private Date gmtModifier;

    private Date gmtCreated;

}
