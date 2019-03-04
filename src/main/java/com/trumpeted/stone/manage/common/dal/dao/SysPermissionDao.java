package com.trumpeted.stone.manage.common.dal.dao;

import com.trumpeted.stone.manage.common.dal.dataobject.SysPermissionDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ylc
 * @since 2019-02-28
 */
public interface SysPermissionDao{

    @Select("select * from sys_permission where id = #{id}")
    SysPermissionDo findById(@Param("id") long id);

    @Select("select * from sys_permission order by gmt_modifier desc limit #{startNo},#{pageSize}")
    List<SysPermissionDo> findByPage(@Param("startNo") int startNo, @Param("pageSize") int pageSize);

    @Select("select count(1) from sys_permission")
    long count();

    @Insert("insert into sys_permission(name, role_id, user_id, gmt_modifier, gmt_created)"
            + " values(#{permission.name}, #{permission.roleId}, #{permission.userId}, now(), now())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("permission") SysPermissionDo permissionDo);

    @Update("update sys_role set name=#{permission.name}, user_id=#{permission.userId}, role_id=#{permission.roleId}, gmt_modifier=now()")
    int updateById(@Param("permission") SysPermissionDo permissionDo);

}
