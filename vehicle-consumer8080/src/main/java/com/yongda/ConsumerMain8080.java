package com.yongda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther yuank
 * @CreateTime 2020/11/19 16:59
 **/
@SpringBootApplication
@EnableFeignClients
public class ConsumerMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain8080.class,args);
    }
}
