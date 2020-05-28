package com.yk.springcloud.service.impl;

import com.yk.springcloud.dao.PaymentDao;
import com.yk.springcloud.entities.Payment;
import com.yk.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther yuank
 * @CreateTime 2020/5/9 15:53
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    };

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    };
}
