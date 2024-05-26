package org.example.springdata.controller;

import org.example.springdata.model.AccountJDBC;
import org.example.springdata.model.TransferRequest;
import org.example.springdata.service.TransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequest request) {
        this.transferService.transferMoney(request.getSenderId(), request.getReceiverId(), request.getAmount());
    }

    @GetMapping("/accounts")
    public List<AccountJDBC> getAllAccounts() {
        return transferService.getAllAccounts();
    }

}
