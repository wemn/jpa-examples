package com.example.jpaexamples.example11.optimistic.repository;

import com.example.jpaexamples.example11.optimistic.entity.Address11;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class Address11Reposityory {
    @PersistenceContext
    private EntityManager em;
    public void persist(Address11 address) {
        em.persist(address);
    }

    public void updateAddressDetail(int id, String newDetail) {
        em.find(Address11.class, 1).setDetail(newDetail);
    }
}
