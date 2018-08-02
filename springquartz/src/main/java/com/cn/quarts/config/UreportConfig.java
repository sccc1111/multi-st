package com.cn.quarts.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.bstek.ureport.console.UReportServlet;
/**
 * Created by songbo on 2018/7/27.
 */
@Configuration
@ImportResource("classpath:ureport-context.xml")
public class UreportConfig {
    @Bean
    public ServletRegistrationBean initUReport() {
        return new ServletRegistrationBean(new UReportServlet(), "/ureport/*");
    }
}
