package com.database.weixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@ComponentScan({"com.database.weixin.config.dao", "com.database.weixin.config.service", "com.database.weixin.dao", "com.database.weixin.entity", "com.database.weixin.service.impl", "com.database.weixin.handler", "com.database.weixin.service", "com.database.weixin.web"})
public class WeixinApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeixinApplication.class, args);
    }
}
