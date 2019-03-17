package com.example.jpaexamples.example11.optimistic.repository;

import com.example.jpaexamples.example11.optimistic.entity.User11;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class User11Reposityory {
    @PersistenceContext
    private EntityManager em;
    public void persist(User11 u) {
        em.persist(u);
    }
    public void updteUserName(int id, String newName) {
        em.find(User11.class, id).setName(newName);
    }
}
