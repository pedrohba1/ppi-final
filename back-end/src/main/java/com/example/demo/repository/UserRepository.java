package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query(
            value = "SELECT distinct user FROM User user" +
                    "WHERE user.userName = :userName"
    )
    User findByUserName(@Param("userName") String userName);
}
