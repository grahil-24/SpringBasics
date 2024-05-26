package org.example.springdata.service;

import org.example.springdata.model.Account;
import org.example.springdata.model.AccountJDBC;
import org.example.springdata.repository.AccountRepository;
import org.example.springdata.repository.AccountRepositoryJDBC;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TransferService {

//    private final AccountRepository accountRepository;
    private final AccountRepositoryJDBC accountRepositoryJDBC;

    public TransferService(AccountRepositoryJDBC accountRepositoryJDBC) {
//        this.accountRepository = accountRepository;
        this.accountRepositoryJDBC = accountRepositoryJDBC;
    }

    //informs spring that this is a transaction, which means all operation complete successfully
    //or none of them do. Maintains data consistency. Is implemented with help of Spring Aspect
    @Transactional
    public void transferMoney(long senderId, long receiverId, BigDecimal amount) {
        Optional<AccountJDBC> sender = accountRepositoryJDBC.findById(senderId);
        Optional<AccountJDBC> receiver = accountRepositoryJDBC.findById(receiverId);

        BigDecimal senderNewAmt = sender.get().getAmount().subtract(amount);
        BigDecimal receiverNewAmt = receiver.get().getAmount().add(amount);

        accountRepositoryJDBC.updateAccount(senderId, senderNewAmt);
        accountRepositoryJDBC.updateAccount(receiverId, receiverNewAmt);

    }

    public List<AccountJDBC> getAllAccounts() {
        return (List<AccountJDBC>) accountRepositoryJDBC.findAll();
    }
}
