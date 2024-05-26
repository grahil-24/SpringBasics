package org.example.springbootmvc.service;

import org.example.springbootmvc.ErrorHandling.NotEnoughMoneyException;
import org.example.springbootmvc.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}