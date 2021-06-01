package com.hbsi.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "repair",resultMap = "repairResultMap")
public class Repair {
    @TableId
    public int rid;
    public Equipment equipment;
    public int ecount;
    public double rmoney;
    public int rstate;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
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

    public double getRmoney() {
        return rmoney;
    }

    public void setRmoney(double rmoney) {
        this.rmoney = rmoney;
    }

    public int getRstate() {
        return rstate;
    }

    public void setRstate(int rstate) {
        this.rstate = rstate;
    }
}
