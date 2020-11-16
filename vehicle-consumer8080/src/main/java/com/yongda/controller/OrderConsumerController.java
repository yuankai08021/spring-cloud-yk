package com.yongda.controller;

import com.yongda.entities.CommonResult;
import com.yongda.entities.Order;
import com.yongda.service.OrderConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther yuank
 * @CreateTime 2020/11/20 15:36
 **/
@RestController
@Slf4j
public class OrderConsumerController {
    @Resource
    private OrderConsumerService orderConsumerService;

    @GetMapping(value="/consumer/order/get/{id}")
    public CommonResult<Order> getOrderById(@PathVariable("id") Long id) {
        return orderConsumerService.getOrderById(id);
    }
}
