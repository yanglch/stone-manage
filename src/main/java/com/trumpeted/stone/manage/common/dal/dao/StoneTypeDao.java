/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.common.dal.dao;

import com.trumpeted.stone.manage.biz.shared.vo.StoneTypeVo;
import com.trumpeted.stone.manage.common.dal.dataobject.StoneDo;
import com.trumpeted.stone.manage.common.dal.dataobject.StoneTypeDo;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 *
 * @author ylc
 * @version $Id: StoneTypeDao.java, v 0.1 2019年03月05日 1:52 ylc Exp $
 */
public interface StoneTypeDao {

    @Select("select * from stone_type where id = #{id}")
    StoneTypeDo findById(@Param("id")long id);

    @Select("select * from stone_type order by gmt_modifier desc limit #{startNo},#{pageSize}")
    List<StoneTypeDo> findByPage(@Param("startNo") int startNo, @Param("pageSize") int pageSize);

    @Select("select count(1) from stone_type")
    long count();


    @Insert("insert into stone_type(name,status, gmt_modifier, gmt_created)"
            + " values(#{name},#{status}, now(), now())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(StoneTypeDo stoneTypeDo);

    @Update("update stone_type set name=#{stoneType.name}, gmt_modifier=now() where id = #{stoneType.id}")
    int updateById(@Param("stoneType") StoneTypeDo stoneTypeDo);

    @Select("select * from stone_type")
    List<StoneTypeVo> selectAll();

    @Select("select * from stone_type where name =#{name}")
    StoneTypeDo selectByName(String name);

    @Select("select * from stone_type where id =#{id}")
    StoneTypeDo selectById(int id);

    @Update("update stone_type set name=#{name} where id=#{id}")
    void updateName(@Param("id") int id, @Param("name") String name);

    @Update("update stone_type set status=#{status} where id=#{id}")
    void updateStatus(@Param("id") int id, @Param("status") int status);

    @Select("select * from stone_type where status=#{status}")
    List<StoneDo> selectByStatus(int status);
}