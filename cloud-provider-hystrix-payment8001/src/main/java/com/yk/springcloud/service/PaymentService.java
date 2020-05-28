package com.yk.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Auther yuank
 * @CreateTime 2020/5/21 10:31
 **/
@Service
public class PaymentService {

    public String paymentInfo_ok(Integer id) {
        return "线程池： " + Thread.currentThread().getName() +" paymentInfo_ok,id:"+ id;
    }

    // 无论超时还是运行异常都会调用兜底方法
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String paymentInfo_timeout(Integer id) {
        int timeNumber = 3000;
        try{
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        // int i = 10/0;
        return "线程池： " + Thread.currentThread().getName() +" paymentInfo_timeout,id:"+ id + " 耗时：" + timeNumber;
    }

    public String paymentInfo_timeoutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() +" 系统繁忙，请稍后再试,id:"+ id;
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value="true"), // 是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"), // 判断熔断的最少请求数，默认是10；只有在一个统计窗口内处理的请求数量达到这个阈值，才会进行熔断与否的判断
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"), // 熔断多少秒后去尝试请求
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60") // 判断熔断的阈值，默认值50，表示在一个统计窗口内有50%的请求处理失败，会触发熔断
    })
    public String paymentCircuitBreaker(Integer id) {
        if(id < 0) {
            throw new RuntimeException("*******id不能负数");
        }
        return "线程池： " + Thread.currentThread().getName() +" 调用成功,流水号:"+ IdUtil.simpleUUID();
    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id不能为负数，请稍后再试!";
    }
}
