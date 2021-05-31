package com.hbsi.entity;


import com.baomidou.mybatisplus.annotation.TableId;


public class Repair {
    @TableId
    public int rid;
    public int eid;
    public int ecount;
    public double rmoney;
    public int rstate;

    @Override
    public String toString() {
        return "Repair{" +
                "rid=" + rid +
                ", eid=" + eid +
                ", ecount=" + ecount +
                ", rmoney=" + rmoney +
                ", rstate=" + rstate +
                '}';
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
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
