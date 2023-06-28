package com.example.demo.repository;

import com.example.demo.domain.Account_test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountTestRepository extends JpaRepository<Account_test, Long> {
    List<Account_test> findAll();
}
