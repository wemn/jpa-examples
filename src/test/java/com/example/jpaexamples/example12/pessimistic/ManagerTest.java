package com.example.jpaexamples.example12.pessimistic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ManagerTest {
    @Autowired
    private User12Service userService;
    @Test
    public void init() {
        userService.addUser(new User12("BO", 1000));
    }
    @Test
    public void buy() {
        userService.buy(1, 600);
    }
    @Test
    public void buyTest() {
        new Thread(() -> {
            userService.buy(1, 600);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            userService.buy(1, 600);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
