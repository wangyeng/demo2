/*
 * All rights Reserved, Designed By DataDriver
 * Copyright:    DataDriver.Inc
 * Company:      Zhuo Wo Infomation Technology (ShangHai) CO.LTD
 */
package com.datadriver;

import com.datadriver.config.FinalConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 默认启动方式(包含自带容器Tomcat)
 */
@SpringBootApplication
@EnableRedisHttpSession
@MapperScan(FinalConfig.MAPPER_SCAN_BASE_PACKAGE)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}