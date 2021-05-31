package com.hbsi.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class Scrap {
    @TableId
    public int sid;
    public Equipment equipment;
    public int ecount;


    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public int getEcount() {
        return ecount;
    }

    public void setEcount(int ecount) {
        this.ecount = ecount;
    }
}
