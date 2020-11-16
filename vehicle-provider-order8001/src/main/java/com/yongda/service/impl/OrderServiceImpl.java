package com.yongda.service.impl;

import com.yongda.dao.OrderDao;
import com.yongda.entities.Order;
import com.yongda.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther yuank
 * @CreateTime 2020/11/19 15:53
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    public int create(Order order) {
        return orderDao.create(order);
    };

    public Order getOrderById(Long id) {
        return orderDao.getOrderById(id);
    };
}
