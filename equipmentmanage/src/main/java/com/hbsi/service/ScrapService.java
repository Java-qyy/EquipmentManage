package com.hbsi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.hbsi.dao.ScrapDao;
import com.hbsi.entity.Page;
import com.hbsi.entity.Scrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ScrapService {

    @Autowired
    ScrapDao scrapDao;

    public List<Scrap> findAll(Page page) {

        if (!StringUtils.hasText(page.getQueryString())){
            page.setQueryString("");
        }

        PageHelper.startPage(page.getPage(), page.getSize());
        List<Scrap> scraps = scrapDao.findAll("%"+page.getQueryString()+"%");
        return scraps;
    }

    public int add(Integer eid, Integer ecount) {
        QueryWrapper<Scrap> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("eid",eid);
        Scrap scrap = scrapDao.selectOne(queryWrapper);
        if(scrap == null){
            return scrapDao.add(eid,ecount);
        }
        scrap.setEcount(scrap.getEcount()+ecount);
//        scrapDao.update(scrap,null);
        return scrapDao.updateById(scrap);
    }
}
