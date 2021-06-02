package com.hbsi.controller;

import com.github.pagehelper.PageInfo;
import com.hbsi.entity.Page;
import com.hbsi.entity.Repair;
import com.hbsi.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 库存维修模块
 */
@RestController
@RequestMapping("/repair")
@CrossOrigin
public class RepairController {

    @Autowired
    RepairService repairService;

    /**
     * 分页查询全部的维修记录
     * @return
     */
    @RequestMapping("/all")
    public Map<String,Object> findAll(@RequestBody Page page){

        Map<String,Object> map = new HashMap<>();

        try {
            List<Repair> repairs = repairService.findAll(page);

            PageInfo pageInfo = new PageInfo(repairs);
            map.put("data",pageInfo.getList());
            map.put("total",pageInfo.getTotal());
            map.put("msg","查询成功");
            map.put("flag",true);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("flag",false);
            map.put("msg","查询失败");
            return map;
        }
    }

    /**
     * 维修指定器材
     * @return
     */
    @RequestMapping("/repair")
    public Map<String,Object> repairEquipment(
            @RequestParam(required = true) Integer rid,
            @RequestParam(required = true) Integer eid,
            @RequestParam(required = true) Integer ecount){
        Map<String,Object> map = new HashMap<>();

        try {
            repairService.repairEquipment(rid,eid,ecount);
            map.put("flag",true);
            map.put("msg","维修成功");
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("flag",false);
            map.put("msg","维修失败");
            return map;
        }
    }




    @RequestMapping("/Alall")
    public Map<String,Object> findAlAll(@RequestBody Page page){

        Map<String,Object> map = new HashMap<>();

        try {
            List<Repair> repairs = repairService.findAlAll(page);

            PageInfo pageInfo = new PageInfo(repairs);
            map.put("data",pageInfo.getList());
            map.put("total",pageInfo.getTotal());
            map.put("msg","查询成功");
            map.put("flag",true);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("flag",false);
            map.put("msg","查询失败");
            return map;
        }
    }


}
