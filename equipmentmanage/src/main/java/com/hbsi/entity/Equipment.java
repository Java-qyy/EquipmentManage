package com.hbsi.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import sun.security.krb5.internal.crypto.EType;

public class Equipment {
    @TableId
    public int eid;
    public String ename;
    public EType eType;
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

    public EType geteType() {
        return eType;
    }

    public void seteType(EType eType) {
        this.eType = eType;
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
