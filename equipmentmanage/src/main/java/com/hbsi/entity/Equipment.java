package com.hbsi.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import sun.security.krb5.internal.crypto.EType;

public class Equipment {
    @TableId
    public int eid;
    public String ename;
    @TableField(exist = false)
    public EquipmentType equipmentType;
    public double eprice;
    public int ecount;


    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public double getEprice() {
        return eprice;
    }

    public void setEprice(double eprice) {
        this.eprice = eprice;
    }

    public int getEcount() {
        return ecount;
    }

    public void setEcount(int ecount) {
        this.ecount = ecount;
    }
}
