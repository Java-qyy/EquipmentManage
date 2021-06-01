package com.hbsi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbsi.entity.Repair;

import java.util.List;


public interface RepairDao extends BaseMapper<Repair>{

    List<Repair> findAll(String queryString);
}
