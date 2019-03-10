package com.example.jpaexamples.example06.manytomany;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
public class ManagerTest {
    @PersistenceContext
    private EntityManager em;

    @Test
    public void addUserAddressTest() {
        User06 u1 = new User06("BO");
        em.persist(u1);
        User06 u2 = new User06("SUN");
        em.persist(u2);

        Address06 a1 = new Address06("956");
        em.persist(a1);
        Address06 a2 = new Address06("925");
        em.persist(a2);
    }

    @Test
    public void addUserAddressTest2() {
        var u1 = em.find(User06.class, 1);
        var a2 = em.find(Address06.class, 2);
        UserAddress06 userAddress = new UserAddress06();
        userAddress.setUser(u1);
        userAddress.setAddress(a2);
        em.persist(userAddress);

    }
}
