package org.example.springdata.repository;

import org.example.springdata.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select u from users u WHERE u.name =:name")
    User findByName(@Param("name") String name);
}
