package com.yongda.dao;

import com.yongda.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther yuank
 * @CreateTime 2020/11/19 15:33
 **/
@Mapper
public interface AuthDao {
    public int create(User user);
    public User getUserById(Long id);
}
