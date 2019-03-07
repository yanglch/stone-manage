/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.common.dal.dao;

import com.trumpeted.stone.manage.common.dal.dataobject.StoneDo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ylc
 * @version $Id: StoneDao.java, v 0.1 2019年03月05日 1:53 ylc Exp $
 */
public interface StoneDao {

    @Select("select * from stone where id = #{id}")
    StoneDo findById(@Param("id") long id);

    @Select("select * from stone where type_code = #{typeCode}")
    List<StoneDo> findByTypeCode(@Param("typeCode") String typeCode);

    @Select("select * from stone order by gmt_modifier desc limit #{startNo},#{pageSize}")
    List<StoneDo> findByPage(@Param("startNo") int startNo, @Param("pageSize") int pageSize);


    List<StoneDo> selectAll();

    @Select("select count(1) from stone")
    long count();

    @Insert("insert into stone(name,image,type_id, gmt_modifier, gmt_created)"
            + " values(#{stone.name},#{stone.image},#{stone.typeId}, now(), now())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("stone") StoneDo stoneDo);

    @Update("update stone set name=#{stone.name},type_id=#{stone.typeId}, image=#{stone.image},gmt_modifier=now() where id = #{stone.id}")
    int updateById(@Param("stone") StoneDo stoneDo);

    @Select("select * from stone where id=#{id}")
    StoneDo selectById(int id);

    @Select("select * from stone where name=#{name}")
    StoneDo selectByName(String name);

    @Update("update stone set name=#{name},image=#{image},type_id=#{typeId}, where id=#{id}")
    void update(StoneDo stoneDo);
}