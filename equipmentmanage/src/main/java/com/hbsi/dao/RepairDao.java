package com.hbsi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbsi.entity.Repair;
import org.apache.ibatis.annotations.Insert;

import java.util.List;


public interface RepairDao extends BaseMapper<Repair>{

    List<Repair> findAll(String queryString);

    @Insert(value = {"insert into `repair` values(0,#{eid},#{ecount},#{rmoney},1)"})
    int add(Integer eid, Integer ecount, double rmoney);
}
