package com.yk.springcloud.service.impl;

import com.yk.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @Auther yuank
 * @CreateTime 2020/5/26 15:38
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "PaymentFallbackService fall paymentInfo_ok";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "PaymentFallbackService fall paymentInfo_timeout";
    }
}
