package com.example.jpaexamples.example13.springdatajpa.reposityory.impl;

import com.example.jpaexamples.example13.springdatajpa.reposityory.CustomizedRepoistory;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomizedRespoistoryImpl<T, ID>
        extends SimpleJpaRepository<T, ID> implements CustomizedRepoistory<T, ID> {
    private EntityManager em;

    public CustomizedRespoistoryImpl(JpaEntityInformation entityInformation,
                                     EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.em = entityManager;
    }

    @Override
    public void refresh(T t) {
        em.refresh(t);
    }
}
