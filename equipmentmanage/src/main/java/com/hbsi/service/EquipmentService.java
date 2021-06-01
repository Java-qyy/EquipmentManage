package com.hbsi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.hbsi.dao.EquipmentDao;
import com.hbsi.entity.Equipment;
import com.hbsi.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    public EquipmentDao equipmentDao;


    public List<Equipment> findAll(Page page) {
        QueryWrapper<Equipment> queryWrapper = new QueryWrapper<>();
        if(page.getQueryString()==null){
            page.setQueryString("");
        }
        queryWrapper.like("ename",page.getQueryString());
        PageHelper.startPage(page.getPage(),page.getSize());
        List<Equipment> list = equipmentDao.findAll("%"+page.getQueryString()+"%");
        return list;

    }

    public int add( String name, Integer etid, double eprice, Integer ecount) {
        return equipmentDao.add(name,etid,eprice,ecount);
    }


    public int removeCount(Integer eid,Integer ecount) {
        return equipmentDao.removeCount(eid,ecount);
    }
}
