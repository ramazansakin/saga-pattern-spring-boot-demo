package com.appsdeveloperblog.payments.service;

import com.appsdeveloperblog.core.dto.Payment;
import com.appsdeveloperblog.payments.dao.jpa.entity.PaymentEntity;
import com.appsdeveloperblog.payments.dao.jpa.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    public static final String SAMPLE_CREDIT_CARD_NUMBER = "374245455400126";

    private final PaymentRepository paymentRepository;
    private final CreditCardProcessorRemoteService ccpRemoteService;


    @Override
    public Payment process(Payment payment) {

        BigDecimal totalPrice = payment.productPrice()
                .multiply(new BigDecimal(payment.productQuantity()));
        ccpRemoteService.process(new BigInteger(SAMPLE_CREDIT_CARD_NUMBER), totalPrice);

        PaymentEntity paymentEntity = new PaymentEntity();
        BeanUtils.copyProperties(payment, paymentEntity);
        paymentRepository.save(paymentEntity);

        return new Payment(
                paymentEntity.getId(),
                payment.orderId(),
                payment.productId(),
                payment.productPrice(),
                payment.productQuantity()
        );
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll().stream()
                .map(entity ->
                        new Payment(entity.getId(), entity.getOrderId(), entity.getProductId(),
                                entity.getProductPrice(), entity.getProductQuantity())
                ).toList();
    }

}
