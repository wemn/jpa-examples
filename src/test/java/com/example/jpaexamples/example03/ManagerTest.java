package com.example.jpaexamples.example03;

import com.example.jpaexamples.example03.timestamp.User03;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.Month;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
public class ManagerTest {
    @PersistenceContext
    private EntityManager em;
    @Test
    public void addUser03Test() {
        var birthday = LocalDate.of(1990, Month.JULY, 6);
        User03 user03 = new User03("BO", birthday);
        em.persist(user03);
    }
    @Test
    public void getUser03Test() {
        User03 u = em.find(User03.class, 1);
        u.setName("SUN");
    }
}
