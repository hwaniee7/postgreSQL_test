package com.example.demo.service;

import com.example.demo.domain.Account_test;
import com.example.demo.repository.AccountTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class AccountTestServiceImpl implements AccountTestService{

    private final AccountTestRepository accountTestRepository;
    @Override
    public List<Account_test> getList() {
        return accountTestRepository.findAll();
    }
}
