package com.yongda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther yuank
 * @CreateTime 2020/11/19 14:43
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class OrderMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8001.class, args);
    }
}
