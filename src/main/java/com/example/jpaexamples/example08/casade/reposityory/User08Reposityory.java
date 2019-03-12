package com.example.jpaexamples.example08.casade.reposityory;

import com.example.jpaexamples.example08.casade.entity.Address08;
import com.example.jpaexamples.example08.casade.entity.User08;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
@Slf4j
public class User08Reposityory {
    @PersistenceContext
    private EntityManager em;
    public void persistCasade() {
        User08 user = new User08("BO");

        Address08 a1 = new Address08("925");
        a1.setUser(user);
        em.persist(a1);
        Address08 a2 = new Address08("956");
        a2.setUser(user);
        em.persist(a2);
    }
    public void removeCasade() {
        User08 user = em.find(User08.class, 1);
        em.remove(user);
    }
}
