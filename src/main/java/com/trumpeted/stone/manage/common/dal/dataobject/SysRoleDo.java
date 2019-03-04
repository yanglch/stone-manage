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
public class SysRoleDo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String userId;

    private String permissionId;

    private Date gmtModifier;

    private Date gmtCreated;

}
