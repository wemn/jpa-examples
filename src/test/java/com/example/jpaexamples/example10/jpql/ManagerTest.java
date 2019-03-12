package com.example.jpaexamples.example10.jpql;

import com.example.jpaexamples.example10.jpql.repository.User10Reposityory;
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
    private User10Reposityory userRep;
    @Test
    public void init() {
        userRep.init();
    }
    @Test
    public void fromTest() {
        userRep.from();
    }
    @Test
    public void whereTest() {
        userRep.where();
    }

    @Test
    public void select5Test() {
        userRep.select5();
    }
}
