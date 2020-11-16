package com.yongda.service;

import com.yongda.entities.CommonResult;
import com.yongda.entities.Order;
import com.yongda.service.impl.OrderServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther yuank
 * @CreateTime 2020/11/19 15:50
 **/
public interface OrderService{
    public int create(Order order);
    public Order getOrderById(@Param("id") Long id);

}
