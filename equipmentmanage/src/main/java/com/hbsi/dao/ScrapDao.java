package com.hbsi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbsi.entity.Scrap;

import java.util.List;

public interface ScrapDao extends BaseMapper<Scrap> {


    List<Scrap> findAll(String queryString);
}
