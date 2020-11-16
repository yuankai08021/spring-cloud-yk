package com.yongda.service.imp;

import com.yongda.dao.LoanDao;
import com.yongda.service.LoanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @decription 工商银行接口实现类
 * @Auther yuank
 * @CreateTime 2020/11/12 14:45
 **/
@Service
public class ICBCLoanServiceImp implements LoanService {

    @Resource
    private LoanDao loanDao;

    @Override
    public String queryCreditLine(String cert) {
        return loanDao.queryCreditLine(cert);
    }
}
