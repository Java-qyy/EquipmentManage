package com.hbsi.controller;

import com.hbsi.entity.Equipment;
import com.hbsi.entity.EquipmentType;
import com.hbsi.entity.Page;
import com.hbsi.service.EquipmentService;
import com.hbsi.service.RepairService;
import com.hbsi.service.ScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EquipmentController {

    @Autowired
    public EquipmentService equipmentService;
    @Autowired
    public RepairService repairService;
    @Autowired
    public ScrapService scrapService;


    /**
     * 器材查询
     * @param page
     * @return
     */
    @RequestMapping(value = "/equipment/all")
    public Map<String,Object> findAll(@RequestBody Page page){

        List<Equipment> list = equipmentService.findAll(page);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","查询成功");
        map.put("flag",true);
        map.put("data",list);
        return map;
    }



    @RequestMapping(value = "/equipment/add")
    public Map<String,Object> add(String name, Integer etid, double eprice, Integer ecount){
        Map<String,Object> map = new HashMap<>();
        int no = equipmentService.add(name,etid,eprice,ecount);
        if(no!=0){
            map.put("msg","添加成功");
            map.put("flag",true);
            return map;
        }else{
            map.put("msg","添加失败");
            map.put("flag",false);
            return map;
        }
    }

    @RequestMapping(value = "/equipment/repair")
    public Map<String,Object> add(Integer eid, Integer ecount, double rmoney){
        Map<String,Object> map = new HashMap<>();
        int no = repairService.add(eid,ecount,rmoney);
        if(no!=0){
            //去除相应的器材数量
            int non = equipmentService.removeCount(eid,ecount);
            if(non!=0){
                map.put("msg","添加到维修成功");
                map.put("flag",true);
                return map;
            }else{
                map.put("msg","添加到维修失败");
                map.put("flag",false);
                return map;
            }
        }else {
            map.put("msg","添加到维修失败");
            map.put("flag",false);
            return map;
        }
    }



    @RequestMapping(value = "/equipment/scrap")
    public Map<String,Object> addScrap(Integer eid, Integer ecount){
        Map<String,Object> map = new HashMap<>();
        int no = scrapService.add(eid,ecount);
        if(no!=0){
            //去除相应的器材数量
            int non = equipmentService.removeCount(eid,ecount);
            if(non!=0){
                map.put("msg","添加到报废成功");
                map.put("flag",true);
                return map;
            }else{
                map.put("msg","添加到报废失败");
                map.put("flag",false);
                return map;
            }
        }else {
            map.put("msg","添加到报废失败");
            map.put("flag",false);
            return map;
        }
    }


}
