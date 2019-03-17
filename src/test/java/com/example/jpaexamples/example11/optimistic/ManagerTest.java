package com.example.jpaexamples.example11.optimistic;

import com.example.jpaexamples.example11.optimistic.entity.Address11;
import com.example.jpaexamples.example11.optimistic.entity.User11;
import com.example.jpaexamples.example11.optimistic.repository.Address11Reposityory;
import com.example.jpaexamples.example11.optimistic.repository.User11Reposityory;
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
    private User11Reposityory userRep;
    @Autowired
    private Address11Reposityory addressRep;
    @Test
    public void initUser() {
        userRep.persist(new User11("BO"));
    }
    @Test
    public void initAddress() {
        addressRep.persist(new Address11("956"));
    }
    @Test
    public void testUser() {
        userRep.updteUserName(1, "SUN");
    }
    @Test
    public void testAddress() {
        addressRep.updateAddressDetail(1, "925");
    }

    @Test
    public void testUserOpt() {
        new Thread(() -> {
            userRep.updteUserName(1, "aa");
            try {
                Thread.sleep(600);
                log.debug("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            userRep.updteUserName(1, "bb");
            try {
                Thread.sleep(200);
                log.debug("1");
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

    @Test
    public void testAddressOpt() {
        new Thread(() -> {
            addressRep.updateAddressDetail(1, "aa");
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            addressRep.updateAddressDetail(1, "bb");
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
