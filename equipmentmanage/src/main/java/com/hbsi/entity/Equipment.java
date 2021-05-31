package com.hbsi.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class Equipment {
    @TableId
    public int eid;
    public String ename;
    public int etid;
    public double eprice;
    public int ecount;


    @Override
    public String toString() {
        return "Equipment{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", etid=" + etid +
                ", eprice=" + eprice +
                ", ecount=" + ecount +
                '}';
    }

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

    public int getEtid() {
        return etid;
    }

    public void setEtid(int etid) {
        this.etid = etid;
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
