package com.hbsi.controller;

import com.github.pagehelper.PageInfo;
import com.hbsi.entity.Page;
import com.hbsi.entity.Repair;
import com.hbsi.entity.Scrap;
import com.hbsi.service.ScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/scrap")
public class ScrapController {


    @Autowired
    ScrapService scrapService;
    /**
     * 分页查询全部的报废记录记录
     * @return
     */
    @RequestMapping("/all")
    public Map<String,Object> findAll(@RequestBody Page page){

        Map<String,Object> map = new HashMap<>();

        try {
            List<Scrap> scraps = scrapService.findAll(page);

            PageInfo pageInfo = new PageInfo(scraps);
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
