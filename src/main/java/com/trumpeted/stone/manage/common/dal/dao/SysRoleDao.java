package com.trumpeted.stone.manage.common.dal.dao;

import com.trumpeted.stone.manage.common.dal.dataobject.SysRoleDo;
import com.trumpeted.stone.manage.common.dal.dataobject.SysUserDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SysRoleDao {

    @Select("select * from sys_role where id = #{id}")
    SysRoleDo findById(@Param("id") long id);

    @Select("select * from sys_role order by gmt_modifier desc limit #{startNo},#{pageSize}")
    List<SysRoleDo> findByPage(@Param("startNo") int startNo, @Param("pageSize") int pageSize);

    @Select("select count(1) from sys_role")
    long count();

    @Insert("insert into sys_role(name, user_id, permission_id, gmt_modifier, gmt_created)"
            + " values(#{role.name}, #{role.userId}, #{role.permissionId}, now(), now())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("role") SysRoleDo roleDo);

    @Update("update sys_role set name=#{name}, user_id=#{userId}, pass_word=#{role.permissionId}, gmt_modifier=now()")
    int updateById(@Param("role") SysRoleDo roleDo);
}
