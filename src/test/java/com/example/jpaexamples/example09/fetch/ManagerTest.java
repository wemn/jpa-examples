package com.example.jpaexamples.example09.fetch;

import com.example.jpaexamples.example09.entity.Address09;
import com.example.jpaexamples.example09.entity.User09;
import com.example.jpaexamples.example09.reposityory.User09Repository;
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
    private User09Repository userRep;
    @Test
    public void init() {
        userRep.init();
    }
    @Test
    public void fetch1Test() {
        userRep.fetch1();
    }
    @Test
    public void test1() {
        User09 u = userRep.getUser(1);
        log.debug(u.getName());
        u .getAddresses()
                .forEach(a -> {log.debug(a.getDetail());});

    }

    @Test
    public void test2() {
        Address09 add = userRep.getAddress(1);
        log.debug(add.getDetail());
        log.debug(add.getUser().getName());
    }
}
