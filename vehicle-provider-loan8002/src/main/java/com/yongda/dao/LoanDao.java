package com.yongda.dao;

import com.yongda.entities.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther yuank
 * @CreateTime 2020/11/12 14:50
 **/
@Mapper
public interface LoanDao {
    public String queryCreditLine(String cert);
}
