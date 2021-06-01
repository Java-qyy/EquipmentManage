package com.hbsi.service;

import com.github.pagehelper.PageHelper;
import com.hbsi.dao.ScrapDao;
import com.hbsi.entity.Page;
import com.hbsi.entity.Scrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScrapService {

    @Autowired
    ScrapDao scrapDao;

    public List<Scrap> findAll(Page page) {

        PageHelper.startPage(page.getPage(), page.getSize());
        List<Scrap> scraps = scrapDao.findAll(page.getQueryString());
        return scraps;
    }

    public int add(Integer eid, Integer ecount) {
        return scrapDao.add(eid,ecount);
    }
}
