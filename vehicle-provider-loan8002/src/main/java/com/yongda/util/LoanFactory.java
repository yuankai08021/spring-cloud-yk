package com.yongda.util;

import com.yongda.service.LoanService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.lang.model.type.UnknownTypeException;

/**
 * @Description 借据工厂类，根据不同的银行代码返回相对应的服务，
 * 各个服务独立调用不同的资方银行提供的接口
 * @Auther yuank
 * @CreateTime 2020/11/12 15:22
 **/
@Component
public class LoanFactory {
    // 兴业银行
    @Resource(name="CIBLoanServiceImp")
    private LoanService cibloanService;
    // 工商银行
    @Resource(name="ICBCLoanServiceImp")
    private LoanService icbcloanService;

    public LoanService getBankService(String bankId) {
        switch(bankId){
            case "CIB":
                return cibloanService;
            case "ICBC":
                return icbcloanService;
            default:
                throw new UnknownTypeException(null, bankId);
        }
    }

}
