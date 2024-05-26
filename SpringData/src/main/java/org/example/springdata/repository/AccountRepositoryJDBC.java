package org.example.springdata.repository;


import org.example.springdata.model.AccountJDBC;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

//CrudRepository is a part of spring data jdbc which provides CRUD functionality
//First type is the model(class) name and the second is the datatype of the primary key
public interface AccountRepositoryJDBC extends CrudRepository<AccountJDBC, Long> {

    //spring data interprets sql queries based on method name, following some convention
    //for queries on id field, there are built in methods, we dont need to write anything

    //for long and complex queries it is better to provide custom query using @Query annotation
    @Query("SELECT * FROM account WHERE name = :name")
    List<AccountJDBC> findAccountsByName(String name);

    //when a query changes data in the database we need to use the @Modifying annotation
    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void updateAccount(long id, BigDecimal amount);

}
