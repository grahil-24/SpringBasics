package org.example.springdata.model;

import java.math.BigDecimal;

public class Account {
    private long id;
    private String name;
    private BigDecimal balance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setAmount(BigDecimal amount) {
        this.balance = amount;
    }
}
