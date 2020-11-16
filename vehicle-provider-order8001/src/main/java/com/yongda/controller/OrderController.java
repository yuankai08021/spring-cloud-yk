package com.yongda.controller;

import com.yongda.entities.CommonResult;
import com.yongda.entities.Order;
import com.yongda.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther yuank
 * @CreateTime 2020/11/19 15:59
 **/
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value="/order/create")
    public CommonResult create(@RequestBody Order order) {
        int result = orderService.create(order);
        log.info("****插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据成功, port:" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败, port:" + serverPort, null);
        }
    }

    @GetMapping(value="/order/get/{id}")
    public CommonResult getOrderById(@PathVariable("id") Long id) {
        Order order = orderService.getOrderById(id);
        log.info("****查询结果：" + order);

        if(order != null){
            return new CommonResult(200,"查询成功, port:" + serverPort,order);
        }else{
            return new CommonResult(444,"没有查询到记录，查询ID:"+id+"; port:"+serverPort,null);
        }
    }

    @GetMapping(value="/order/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("****service：" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }

}
