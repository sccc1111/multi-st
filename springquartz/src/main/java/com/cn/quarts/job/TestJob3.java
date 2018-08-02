package com.cn.quarts.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.Serializable;

/**
 * Created by songbo on 2018/7/26.
 */
public class TestJob3 implements Job,Serializable {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("=================TestJob3 执行==============");
    }
}