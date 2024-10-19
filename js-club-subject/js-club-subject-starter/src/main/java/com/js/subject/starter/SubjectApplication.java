package com.js.subject.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 刷题微服务启动类
 *
 * @author jiaoshuai
 * @date 2024/6/23 22:43
 */
@SpringBootApplication
@ComponentScan("com.js")
@MapperScan("com.js.**.mapper")
@EnableFeignClients(basePackages = "com.js")
public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class);
    }

}
