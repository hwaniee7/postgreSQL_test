package com.example.demo.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Data
@Table(name = "ACCOUNT_TEST")
public class Account_test {
    @Id
    @Column(name="USER_ID")
    private long userid;
    @Column(name="USERNAME")
    private String username;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="EMAIL")
    private String email;
    @Column(name="RDATE")
    @CreationTimestamp //추가
    private Date rdate;
    @Column(name="LAST_LOGIN")
    @CreationTimestamp //추가
    private Date lastLogin;


}
