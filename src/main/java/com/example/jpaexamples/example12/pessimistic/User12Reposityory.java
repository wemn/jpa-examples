package com.example.jpaexamples.example12.pessimistic;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

@Repository
public class User12Reposityory {
    @PersistenceContext
    private EntityManager em;
    public void persist(User12 u) {
        em.persist(u);
    }
    public User12 find(int id) {
        return em.find(User12.class, id, LockModeType.PESSIMISTIC_WRITE);
    }
}
