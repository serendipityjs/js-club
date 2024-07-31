package com.js.club.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
 * oss服务启动类
 *
 * @Author: jiaoshuai
 * @date:  2024/7/7 10:10
 */
@SpringBootApplication
@ComponentScan("com.js")
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class);
    }

}
