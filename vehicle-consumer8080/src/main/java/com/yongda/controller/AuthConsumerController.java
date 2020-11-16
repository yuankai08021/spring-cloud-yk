package com.yongda.controller;

import com.yongda.entities.CommonResult;
import com.yongda.entities.Order;
import com.yongda.service.AuthConsumerService;
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
public class AuthConsumerController {
    @Resource
    private AuthConsumerService authConsumerService;

    @GetMapping(value="/consumer/auth/getuser/{id}")
    public CommonResult<Order> getUserById(@PathVariable("id") Long id) {
        return authConsumerService.getUserById(id);
    }
}
