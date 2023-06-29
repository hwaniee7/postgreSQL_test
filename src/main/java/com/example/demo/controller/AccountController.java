package com.example.demo.controller;


import com.example.demo.domain.Account_test;
import com.example.demo.service.AccountTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600) //#매우 중요!
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountTestService accountTestService;
    @GetMapping("")
    public List<Account_test> getAccountList(Model model){
        List<Account_test> list = accountTestService.getList();
        return list;
    }

    void pln(String str) {
        System.out.println(str);
    }
}
