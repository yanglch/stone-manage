package com.trumpeted.stone.manage.common.dal.dao;

import com.trumpeted.stone.manage.common.dal.dataobject.SysUserDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SysUserDao{

    @Select("select * from sys_user where id = #{id}")
    SysUserDo findById(@Param("id") long id);

    @Select("select * from sys_user where login_name = #{loginName}")
    SysUserDo findByLoginName(@Param("loginName") String loginName);

    @Select("select * from sys_user order by gmt_modifier desc limit #{startNo},#{pageSize}")
    List<SysUserDo> findByPage(@Param("startNo") int startNo, @Param("pageSize") int pageSize);

    @Select("select count(1) from sys_user")
    long count();

    @Insert("insert into sys_user(real_name, login_name, pass_word, salt, role_id, permission_id, gmt_modifier, gmt_created)"
            + " values(#{user.realName}, #{user.loginName}, #{user.passWord}, #{user.salt}, #{user.roleId}, #{user.permissionId}, now(), now())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("user") SysUserDo userDo);

    @Update("update sys_user set real_name=#{realName}, login_name=#{loginName}, pass_word=#{passWord}, salt=#{salt}, "
            + "role_id=#{roleId}, permission_id=#{permissionId}, gmt_modifier=now()")
    int updateById();
}
