package com.example.jpaexamples.example04.onetomany;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
public class ManagerTest {
    @PersistenceContext
    private EntityManager em;
    @Test
    public void addUserAddressesTest() {
        // 先存在user对象
        User04 u = new User04("BO");
        em.persist(u);
        // 再存在address对象
        // 由many端，创建/维护与one端的关系
        Address04 a1 = new Address04("956", u);
        em.persist(a1);
        Address04 a2 = new Address04("925", u);
        em.persist(a2);

    }
}
