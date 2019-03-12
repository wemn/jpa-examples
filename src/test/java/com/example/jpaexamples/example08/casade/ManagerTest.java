package com.example.jpaexamples.example08.casade;

import com.example.jpaexamples.example08.casade.reposityory.User08Reposityory;
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
    private User08Reposityory userRep;
    @Test
    public void test1() {

    }

}
