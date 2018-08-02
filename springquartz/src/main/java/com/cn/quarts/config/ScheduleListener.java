package com.cn.quarts.config;

import com.cn.quarts.model.Cron;
import com.cn.quarts.service.QuartsService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;

/**
 * Created by songbo on 2018/7/26.
 * 添加监听，并监控ContextRefreshedEvent事件（容器初始化完成事件）
 * Bean都初始化好之后，启动定时器。
 */
@Configuration
@Slf4j
public class ScheduleListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired @Qualifier("Scheduler")
    private Scheduler scheduler;

    @Autowired
    private QuartsService quartsServiceImpl;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("启动定时任务");
        List<Cron> cronList = quartsServiceImpl.findAll();
        if(null != cronList && cronList.size() > 0){
            for (Cron cron: cronList) {
                try {
                    Class cls = Class.forName(cron.getClassName()) ;
                    cls.newInstance();
                    JobDetail job = JobBuilder.newJob(cls)
                            .withIdentity(cron.getName(),cron.getTgroup()).withDescription(cron.getDescription()).build();

                    // 触发时间点
                    CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron.getExpression());

                    Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger"+cron.getName(), cron.getTgroup())
                            .startNow().withSchedule(cronScheduleBuilder).build();

                    //交由Scheduler安排触发
                    scheduler.scheduleJob(job, trigger);

                    if("1".equals(cron.getStatus())){
                        scheduler.triggerJob(new JobKey(cron.getName(),cron.getTgroup()));
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (SchedulerException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
