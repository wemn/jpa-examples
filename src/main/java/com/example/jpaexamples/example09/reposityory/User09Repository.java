package com.example.jpaexamples.example09.reposityory;

import com.example.jpaexamples.example09.entity.Address09;
import com.example.jpaexamples.example09.entity.User09;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
@Slf4j
public class User09Repository {
    @PersistenceContext
    private EntityManager em;

    public void init() {
        User09 user = new User09();
        user.setName("BO");
        em.persist(user);
        Address09 address = new Address09();
        address.setDetail("925");
        address.setUser(user);
        em.persist(address);
        Address09 address2 = new Address09();
        address2.setDetail("956");
        address2.setUser(user);
        em.persist(address2);
    }

    public void fetch1() {
        User09 u = em.find(User09.class, 1);
        log.debug(u.getName());
        u.getAddresses()
                .forEach(a -> {log.debug(a.getDetail());});

    }

    public User09 getUser(int uid) {
        return em.find(User09.class, uid);
    }

    public Address09 getAddress(int aid) {
        return em.find(Address09.class, aid);
    }
}
