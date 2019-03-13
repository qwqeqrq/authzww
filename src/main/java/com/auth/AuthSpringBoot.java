package com.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by zww on 2019-03-11.微服务鉴权 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AuthSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(AuthSpringBoot.class, args);
        System.out.println("-----------------微服务鉴权项目已启动");
    }
}
