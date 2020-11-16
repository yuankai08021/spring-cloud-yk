package com.yongda.service;

import com.yongda.entities.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther yuank
 * @CreateTime 2020/11/9 15:50
 **/
public interface AuthService {
    public int create(User user);
    public User getUserById(Long id);
}
