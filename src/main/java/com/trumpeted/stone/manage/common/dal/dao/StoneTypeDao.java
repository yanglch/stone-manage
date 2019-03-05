/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.common.dal.dao;

import com.trumpeted.stone.manage.common.dal.dataobject.StoneTypeDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Insert("insert into stone_type(name, gmt_modifier, gmt_created)"
            + " values(#{stoneType.name}, now(), now())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("stoneType") StoneTypeDo stoneTypeDo);

    @Update("update stone_type set name=#{stoneType.name}, gmt_modifier=now() where id = #{stoneType.id}")
    int updateById(@Param("stoneType") StoneTypeDo stoneTypeDo);
}