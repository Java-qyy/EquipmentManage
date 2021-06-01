package com.hbsi.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbsi.entity.Equipment;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface EquipmentDao extends BaseMapper<Equipment> {

    List<Equipment> findAll(String s);

    @Insert(value = {"insert into equipment values(0,#{name},#{etid},#{eprice},#{ecount})"})
    int add(String name, Integer etid, double eprice, Integer ecount);

    @Update(value = {"update equipment set ecount=ecount-#{ecount} where eid=#{eid}"})
    int removeCount(Integer eid,Integer ecount);
}
