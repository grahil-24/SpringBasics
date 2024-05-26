package org.example.springdata.repository;

import org.example.springdata.AccountRowMapper;
import org.example.springdata.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {

    private final JdbcTemplate jdbcTemplate;
    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findAccountById(long id){
        String sql = "select * from account where id = ?";
        return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), id);
    }

    public void changeAmount(long id, BigDecimal amount){
        String sql = "update account set amount = ? where id = ?";
        jdbcTemplate.update(sql, amount, id);
    }

    public List<Account> findAll(){
        String sql = "select * from account";
        return jdbcTemplate.query(sql, new AccountRowMapper());
    }
}
