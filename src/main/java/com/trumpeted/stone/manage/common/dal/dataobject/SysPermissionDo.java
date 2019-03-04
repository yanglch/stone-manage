package com.trumpeted.stone.manage.common.dal.dataobject;

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
public class SysPermissionDo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String roleId;

    private String userId;

    private Date gmtModifier;

    private Date gmtCreated;

}
