package org.example.springbootmvc.controller;

import org.example.springbootmvc.ErrorHandling.NotEnoughMoneyException;
import org.example.springbootmvc.model.ErrorDetails;
import org.example.springbootmvc.model.PaymentDetails;
import org.example.springbootmvc.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.logging.Logger;

@Controller
public class PaymentController {

    private final PaymentService paymentService;
    private static Logger logger = Logger.getLogger(PaymentController.class.getName());

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    //@RequestBody is used to extract the request body. JSON format is used by default
    public ResponseEntity<?> makePayment(@RequestBody PaymentDetails paymentDetails){
        logger.info("Received payment " +
                paymentDetails.getAmount());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }
}

