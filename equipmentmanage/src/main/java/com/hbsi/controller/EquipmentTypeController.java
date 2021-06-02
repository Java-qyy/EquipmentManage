package com.hbsi.controller;

import com.hbsi.entity.EquipmentType;
import com.hbsi.service.EquipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class EquipmentTypeController {

    @Autowired
    public EquipmentTypeService equipmentTypeService;


    @RequestMapping(value = "/equipmenttype/all")
    public List<EquipmentType> queryAll(){

        return equipmentTypeService.findAll();

    }

}
