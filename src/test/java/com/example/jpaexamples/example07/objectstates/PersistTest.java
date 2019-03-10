package com.example.jpaexamples.example07.objectstates;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PersistTest {
    @Autowired
    private User07Repository userRep;
    @Test
    public void persist1Test() {
        userRep.persist1();
    }

    @Test
    public void persist2Test() {
        User07 u = new User07("BO");
        u = userRep.persist2(u);
        userRep.persist2(u);
    }

    @Test
    public void find1Test() {
        userRep.find1();
    }

    @Test
    public void refresh1Test() {
        userRep.refresh1();
    }
}
