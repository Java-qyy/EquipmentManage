package com.hbsi.job;

import com.hbsi.service.EquipmentService;
import org.apache.solr.client.solrj.SolrServerException;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SolrUpdate extends QuartzJobBean {
    @Autowired
    EquipmentService equipmentService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //获取JobDetail中关联的数据
        //String msg = (String) jobExecutionContext.getJobDetail().getJobDataMap().get("msg");
        System.out.println("current time :"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) );
        try {
            equipmentService.create();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
