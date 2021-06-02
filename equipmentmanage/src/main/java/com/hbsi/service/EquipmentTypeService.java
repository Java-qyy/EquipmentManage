package com.hbsi.service;

import com.hbsi.dao.EquipmentTypeDao;
import com.hbsi.entity.EquipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentTypeService {

    @Autowired
    EquipmentTypeDao equipmentTypeDao;

    public List<EquipmentType> findAll() {
        return equipmentTypeDao.selectList(null);
    }
}
