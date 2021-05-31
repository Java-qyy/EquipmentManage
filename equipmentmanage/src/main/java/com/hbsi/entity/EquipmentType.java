package com.hbsi.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class EquipmentType {
    @TableId
    public int etid;
    public String etname;


    @Override
    public String toString() {
        return "EquipmentType{" +
                "etid=" + etid +
                ", etname='" + etname + '\'' +
                '}';
    }

    public int getEtid() {
        return etid;
    }

    public void setEtid(int etid) {
        this.etid = etid;
    }

    public String getEtname() {
        return etname;
    }

    public void setEtname(String etname) {
        this.etname = etname;
    }
}
