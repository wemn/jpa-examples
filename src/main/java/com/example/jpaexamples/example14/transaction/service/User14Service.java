package com.example.jpaexamples.example14.transaction.service;

import com.example.jpaexamples.example14.transaction.entity.User14;
import com.example.jpaexamples.example14.transaction.exception.MyException;
import com.example.jpaexamples.example14.transaction.repository.User14Reposityory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@Service
@Transactional
public class User14Service {
    @Autowired
    private User14Reposityory userRep;
    public void addUser() {
        userRep.save(new User14("3"));
        // 模拟异常
        try {
            Files.readString(Path.of("A:/aa.aa"));
        } catch (IOException e) {
            throw  new MyException("IO操作异常！" + e.getMessage());
        }
    }
}
