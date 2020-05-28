package com.yk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Auther yuank
 * @CreateTime 2020/5/27 10:59
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9002.class,args);
    }
}
