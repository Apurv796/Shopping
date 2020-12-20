package com.java.example.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.example.common.Payment;
import com.java.example.common.TransactionRequest;
import com.java.example.common.TransactionResponse;
import com.java.example.model.Order;
import com.java.example.dao.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class OrderService {

    @Autowired
    private PaymentRepository repository;

    Logger logger= LoggerFactory.getLogger(PaymentService.class);

    public Payment doPayment(Payment payment) throws JsonProcessingException {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        logger.info("Payment-Service Request : {}",new ObjectMapper().writeValueAsString(payment));

        return repository.save(payment);
    }


    public String paymentProcessing(){
        //api should be 3rd party payment gateway (paypal,paytm...)
        return new Random().nextBoolean()?"success":"false";
    }


    public Payment findPaymentHistoryByOrderId(int orderId) {
        Payment payment=repository.findByOrderId(orderId);
        logger.info("paymentService findPaymentHistoryByOrderId : {}",new ObjectMapper().writeValueAsString(payment));
        return payment ;
    }

}