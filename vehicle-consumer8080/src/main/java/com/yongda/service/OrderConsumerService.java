package com.yongda.service;

import com.yongda.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther yuank
 * @CreateTime 2020/11/19 17:02
 **/
@Component
@FeignClient(value="VEHICLE-PROVIDER-ORDER")
public interface OrderConsumerService {

    @GetMapping(value="/order/get/{id}")
    public CommonResult getOrderById(@PathVariable("id") Long id);
}
