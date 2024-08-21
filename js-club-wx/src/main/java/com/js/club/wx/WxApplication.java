package com.js.club.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
 * 对接微信公众号服务启动类
 *
 * @Author: jiaoshuai
 * @date:  2024/7/31
 */
@SpringBootApplication
@ComponentScan("com.js")
public class WxApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxApplication.class);
    }

}
