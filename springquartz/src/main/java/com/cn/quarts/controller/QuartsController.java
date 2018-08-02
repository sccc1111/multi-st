package com.cn.quarts.controller;

import com.cn.quarts.model.Cron;
import com.cn.quarts.model.Result;
import com.cn.quarts.service.QuartsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zh
 * @ClassName com.cn.quarts.controller.QuartsController
 * @Description
 */
@RestController
@RequestMapping("/quarts")
public class QuartsController {

    @Autowired @Qualifier("Scheduler")
    private Scheduler scheduler;

    @Autowired
    private QuartsService quartsServiceImpl;

    /**
     * 创建任务
     * @param id
     * @return
     */
    @ApiOperation(value="任务对象", notes="根据任务对象创建任务")
    @ApiImplicitParam(name = "cron", value = "任务对象", required = true, dataType = "Cron")
    @GetMapping("/add")
    @Transactional
    public Result save(Cron cron){

        try {
            Class cls = Class.forName(cron.getClassName());
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
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("任务创建失败");
        }
        quartsServiceImpl.add(cron);
        return  Result.ok("保存成功");
    }

    /**
     * 更新任务
     * @param id
     * @return
     */
    @ApiOperation(value="任务对象", notes="根据任务对象更新任务")
    @ApiImplicitParam(name = "cron", value = "任务对象", required = true, dataType = "Cron")
    @GetMapping("/update")
    @Transactional
    public Result update(Cron cron){
        Cron result = quartsServiceImpl.findById(cron.getId());
        if("1".equals(result.getStatus())){
            return Result.error("请先暂停任务，在修改");
        }
        try {
            JobKey key = new JobKey(cron.getName(),cron.getTgroup());
            scheduler.deleteJob(key);

            Class cls = Class.forName(cron.getClassName());
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
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("任务更新失败");
        }
        quartsServiceImpl.update(cron);
        return  Result.ok("更新成功");
    }

    /**
     * 停止任务
     * @param id
     * @return
     */
    @ApiOperation(value="任务对象", notes="根据任务对象更新任务")
    @ApiImplicitParam(name = "id", value = "任务ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/pause/{id}")
    @Transactional
     public Result pause(@PathVariable int id) throws SchedulerException {
        Cron cron = quartsServiceImpl.findById(id);
        cron.setStatus("0");
        quartsServiceImpl.update(cron);
        JobKey key = new JobKey(cron.getName(),cron.getTgroup());
        scheduler.pauseJob(key);
        return  Result.ok("已停止服务");
    }

    /**
     * 停止任务
     * @param id
     * @return
     */
    @ApiOperation(value="停止任务", notes="停止任务")
    @ApiImplicitParam(name = "id", value = "任务ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/resume/{id}")
    @Transactional
    public Result resume(@PathVariable int id) throws SchedulerException {
        Cron cron = quartsServiceImpl.findById(id);
        cron.setStatus("1");
        quartsServiceImpl.update(cron);
        JobKey key = new JobKey(cron.getName(),cron.getTgroup());
        scheduler.resumeJob(key);
        return  Result.ok("已启动服务");
    }

    /**
     * 删除任务
     * @param id
     * @return
     */
    @ApiOperation(value="删除任务", notes="删除任务")
    @ApiImplicitParam(name = "id", value = "任务ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/remove/{id}")
    @Transactional
    public  Result remove(@PathVariable int id) throws SchedulerException {
        Cron cron = quartsServiceImpl.findById(id);
        JobKey key = new JobKey(cron.getName(),cron.getTgroup());
        scheduler.deleteJob(key);
        quartsServiceImpl.delete(cron.getId());
        return  Result.ok("已启动服务");
    }

    /**
     * 查询所有任务
     * @param
     * @return
     */
    @ApiOperation(value="查询所有任务", notes="查询所有任务")
    @RequestMapping("/")
    public List<Cron> find(){
        return quartsServiceImpl.findAll();
    }
}
