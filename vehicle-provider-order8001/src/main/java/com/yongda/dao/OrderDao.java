package com.yongda.dao;

import com.yongda.entities.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther yuank
 * @CreateTime 2020/11/19 15:33
 **/
@Mapper
public interface OrderDao {
    public int create(Order order);
    public Order getOrderById(@Param("id") Long id);
}
