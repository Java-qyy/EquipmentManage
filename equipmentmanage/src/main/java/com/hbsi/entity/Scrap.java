package com.hbsi.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class Scrap {
    @TableId
    public int sid;
    public int eid;
    public int ecount;


    @Override
    public String toString() {
        return "Scrap{" +
                "sid=" + sid +
                ", eid=" + eid +
                ", ecount=" + ecount +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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
}
