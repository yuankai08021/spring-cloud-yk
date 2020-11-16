package com.yongda.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther yuank
 * @CreateTime 2020/11/12 14:44
 **/
public interface LoanService {

    public String queryCreditLine(String cert);
}
