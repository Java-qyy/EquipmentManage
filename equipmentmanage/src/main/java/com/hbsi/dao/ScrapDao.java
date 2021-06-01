package com.hbsi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbsi.entity.Scrap;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface ScrapDao extends BaseMapper<Scrap> {


    List<Scrap> findAll(String queryString);

    @Insert(value = {"insert into scrap values(0,#{eid},#{ecount})"})
    int add(Integer eid, Integer ecount);
}
