package com.sinosoft.cses.view.cses;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class QuartzTask implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //此处只做接口访问请求，记录延时时间（记录的数据用于动态页面显示）
        System.out.println("开始执行定时任务"+new Date());
    }
}
