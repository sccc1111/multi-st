package com.cn.quarts.service;

import com.cn.quarts.model.Cron;

import java.util.List;

/**
 * Created by songbo on 2018/7/26.
 */
public interface QuartsService {

    List<Cron> findAll();

    Cron findById(int id);

    int add(Cron cron);

    int update(Cron cron);

    int delete(int id);
}
