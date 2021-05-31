package com.hbsi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.hbsi.dao.RepairDao;
import com.hbsi.entity.Page;
import com.hbsi.entity.Repair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class RepairService {


    @Autowired
    RepairDao repairDao;

    public List<Repair> findAll(Page page) {
        QueryWrapper<Repair> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("rstate",1);

        if (StringUtils.hasText(page.getQueryString())){//如果有查询条件则添加查询条件
            queryWrapper.like("eid",page.getQueryString());
        }


        PageHelper.startPage(page.getPage(),page.getSize());
        List<Repair> repairs = repairDao.selectList(queryWrapper);
        return repairs;
    }

    public List<Repair> repairEquipment(Integer rid, Integer eid, Integer ecount) {
        return null;
    }
}
