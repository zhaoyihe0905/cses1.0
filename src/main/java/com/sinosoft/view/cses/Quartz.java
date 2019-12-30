package com.sinosoft.view.cses;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Quartz {
    public Quartz() {
        //创建job
        JobDetail job= JobBuilder.newJob(QuartzTask.class).build();
        //TODO 间隔时间需要可配
        //创建触发器
        Trigger trigger=TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever()).build();
        //3创建Scheduler(任务调度)对象
        try {
            Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
