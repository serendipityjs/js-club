package com.js.club.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
 * Auth服务启动类
 *
 * @Author: jiaoshuai
 * @date:  2024/7/31
 */
@SpringBootApplication
@ComponentScan("com.js")
@MapperScan("com.js.**.mapper")
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class);
    }

}
