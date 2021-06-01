package com.hbsi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.hbsi.dao.EquipmentDao;
import com.hbsi.dao.RepairDao;
import com.hbsi.entity.Equipment;
import com.hbsi.entity.Page;
import com.hbsi.entity.Repair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class RepairService {


    @Autowired
    RepairDao repairDao;

    @Autowired
    EquipmentDao equipmentDao;
    /**
     * 查询全部维修记录
     * @param page
     * @return
     */
    public List<Repair> findAll(Page page) {
        if (!StringUtils.hasText(page.getQueryString())){
            page.setQueryString("");
        }
        PageHelper.startPage(page.getPage(),page.getSize());
        List<Repair> repairs = repairDao.findAll("%"+page.getQueryString()+"%");
        return repairs;
    }

    /**
     * 维修指定的器材
     * @param rid
     * @param eid
     * @param ecount
     * @return
     */
    @Transactional
    public void repairEquipment(Integer rid, Integer eid, Integer ecount) {

        Integer e_ecount = ecount;
        Repair r = repairDao.selectById(rid);
        System.out.println(r);
        if (r.getEcount()<ecount){
            throw new RuntimeException();
        }
        Repair repair = new Repair();
        ecount = r.getEcount()-ecount;
        if (ecount == 0){
            repair.setRstate(0);
        }
        repair.setEcount(ecount);
        repair.setRid(rid);
        repair.setRmoney(r.getRmoney());
        repairDao.updateById(repair);

        Equipment equipment = equipmentDao.selectById(eid);
        equipment.setEcount(equipment.getEcount()+e_ecount);
        System.out.println(equipment);
        equipmentDao.updateById(equipment);
    }
}
