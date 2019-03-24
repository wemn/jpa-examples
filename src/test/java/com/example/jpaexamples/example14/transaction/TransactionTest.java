package com.example.jpaexamples.example14.transaction;

import com.example.jpaexamples.example14.transaction.entity.User14;
import com.example.jpaexamples.example14.transaction.service.User14Service;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TransactionTest {
    @Autowired
    private User14Service userService;
    @Test
    public void addUserTest() {
        userService.addUser();
    }
}
