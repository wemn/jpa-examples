package com.example.jpaexamples.example12.pessimistic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class User12Service {
    @Autowired
    private User12Reposityory userRep;
    public void addUser(User12 u) {
        userRep.persist(u);
    }
    public void buy(int id, int expense) {
        User12 u = userRep.find(id);
        log.debug("余额: {}", u.getBalance());
        int newBalance = u.getBalance() - expense;
        if (newBalance >= 0) {
            u.setBalance(newBalance);
            log.debug("花费后余额：{}", newBalance);
        } else {
            log.debug("余额不足");
        }
    }
}
