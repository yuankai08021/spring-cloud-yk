package com.yongda.service.impl;

import com.yongda.dao.AuthDao;
import com.yongda.entities.User;
import com.yongda.service.AuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther yuank
 * @CreateTime 2020/11/19 15:53
 **/
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private AuthDao authDao;

    public int create(User user) {
        return authDao.create(user);
    };

    public User getUserById(Long id) {
        return authDao.getUserById(id);
    };
}
