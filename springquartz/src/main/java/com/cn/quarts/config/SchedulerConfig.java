package com.cn.quarts.config;

import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;

/**
 * Created by songbo on 2018/7/26.
 */
@Configuration
public class SchedulerConfig {

    @Bean(name="SchedulerFactory")
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setAutoStartup(true);
        factory.setConfigLocation(new ClassPathResource("quartz.properties"));
        //factory.setStartupDelay(5);//延时5秒启动
        return factory;
    }

    @Bean(name="Scheduler")
    public Scheduler scheduler() throws IOException {
        return schedulerFactoryBean().getScheduler();
    }
}
