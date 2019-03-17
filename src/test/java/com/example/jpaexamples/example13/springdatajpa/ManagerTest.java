package com.example.jpaexamples.example13.springdatajpa;

import com.example.jpaexamples.example13.springdatajpa.entity.User13;
import com.example.jpaexamples.example13.springdatajpa.service.User13Service;
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
    private User13Service userService;
    @Test
    public void saveTest() {
        User13 u = new User13("BO", "956");
        User13 u2 = userService.addUser(u);
        log.debug("{}", u == u2);
        log.debug("{}", u2.getInsertTime());
    }

    @Test
    public void updateTest() {
        User13 u = new User13();
        u.setId(1);
        u.setName("SUN");
        User13 u2 = userService.addUser(u);
        log.debug("{}", u2.getInsertTime());
    }
    @Test
    public void updateTest2() {
        User13 u = userService.updateUser(1, "SUN");
        log.debug("{}", u.getInsertTime());
    }

    @Test
    public void addTest2() {
        User13 u = userService
                .addUser2(new User13("ZHANG", "774"));
        log.debug("{}", u.getInsertTime());
    }

    @Test
    public void listUserByAddressTest() {
        userService.listUser("956")
                .forEach(u -> {
                    log.debug(u.getName());
                });
    }

    @Test
    public void listUserByPropertyNameTest() {
        userService.listUser2("956")
                .forEach(u -> {
                    log.debug(u.getName());
                });
    }
}
