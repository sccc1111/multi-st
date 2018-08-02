package com.cn.quarts.model;

import lombok.Data;

/**
 * Created by songbo on 2018/7/26.
 */
@Data
public class Cron {
    private int id;
    private String name;
    private String tgroup;
    private String description;
    private String className;
    private String expression;
    private String status;
}
