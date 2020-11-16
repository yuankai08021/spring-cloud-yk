package com.yongda.controller;

import com.yongda.entities.CommonResult;
import com.yongda.service.LoanService;
import com.yongda.util.LoanFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther yuank
 * @CreateTime 2020/11/12 14:43
 **/
@RestController
@Slf4j
public class LoanController {

    @Resource
    private LoanFactory loanFactory;

    @GetMapping(value="/loan/querycreditline/{cert}/{bankId}")
    public CommonResult queryCreditLine(@PathVariable("cert") String cert, @PathVariable("bankId") String bankId) {
        LoanService loanService = loanFactory.getBankService(bankId);
        loanService.queryCreditLine(cert);
        return null;
    }

}
