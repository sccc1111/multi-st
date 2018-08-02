package com.cn.quarts;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by songbo on 2018/7/26.
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2Doc
public class QuartsApp {
    public static void main(String[] args){
        SpringApplication.run(QuartsApp.class,args);
    }
}
