package com.hbsi.config;

import com.hbsi.job.SolrUpdate;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail SolrUpdateJobDetail(){
        return JobBuilder.newJob(SolrUpdate.class)//PrintTimeJob我们的业务类
                .withIdentity("SolrUpdate")//可以给该JobDetail起一个id
                .storeDurably()//即使没有Trigger关联时，也不需要删除该JobDetail
                .build();
    }
    @Bean
    public Trigger printTimeJobTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 0 3 * * ? ");
//        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/35 * * * * ? ");
        return TriggerBuilder.newTrigger()
                .forJob(SolrUpdateJobDetail())//关联上述的JobDetail
                .withIdentity("quartzTaskService")//给Trigger起个名字
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
