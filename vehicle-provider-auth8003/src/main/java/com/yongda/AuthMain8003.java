package com.yongda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther yuank
 * @CreateTime 2020/11/13 14:43
 **/
@SpringBootApplication
@EnableEurekaClient
public class AuthMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(AuthMain8003.class, args);
    }
}
