package com.example.jpaexamples.example10.jpql.repository;

import com.example.jpaexamples.example10.jpql.entity.Address10;
import com.example.jpaexamples.example10.jpql.entity.User10;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
@Slf4j
public class User10Reposityory {
    protected String name;

    @PersistenceContext
    private EntityManager em;
    public void init() {
        User10 user = new User10();
        user.setName("BO");
        em.persist(user);
        User10 user2 = new User10();
        user2.setName("SUN");
        em.persist(user2);

        Address10 address = new Address10();
        address.setDetail("925");
        address.setUser(user);
        em.persist(address);
        Address10 address2 = new Address10();
        address2.setDetail("956");
        address2.setUser(user);
        em.persist(address2);

        Address10 address3 = new Address10();
        address3.setDetail("1201");
        address3.setUser(user2);
        em.persist(address3);
    }

    public void from() {
        String jpql = "SELECT u FROM User10 u";
        Query query = em.createQuery(jpql);
        List<User10> users = query.getResultList();
        users.forEach(u -> {
            log.debug(u.getName());
        });
    }

    public void where() {
        String jpql = "SELECT a FROM Address10 a WHERE a.user.name='BO'";
        List<Address10> addresses = em.createQuery(jpql).getResultList();
        log.debug("" + addresses.size());
        addresses.forEach(a -> {
            log.debug(a.getDetail());
        });
    }

    public void select3() {
        String jpql = "SELECT u.addresses FROM User10 u WHERE u.name='BO'";
        List<Address10> addresses = em.createQuery(jpql).getResultList();
        addresses.forEach(a -> {
            log.debug(a.getDetail());
        });
    }

    public void select4() {
        String jpql = "SELECT a.user FROM Address10 a WHERE a.detail='925'";
        List<User10> users = em.createQuery(jpql).getResultList();
        log.debug("" + users.size());
        users.forEach(u -> {
            log.debug(u.getName());
        });
    }

    public void select5() {
        String jpql = "SELECT u FROM User10 u ORDER BY SIZE(u.addresses) DESC";
        List<User10> users = em.createQuery(jpql).getResultList();
        users.forEach(u -> {
            log.debug(u.getName());
        });
    }

    public void query1() {
        String jpql = "SELECT u.addresses FROM User10 u WHERE u.name=?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, "BO");
        List<Address10> addresses = query.getResultList();
        addresses.forEach(a -> {
            log.debug(a.getDetail());
        });
    }

    public void query2() {
        String jpql = "SELECT a.user FROM Address10 a WHERE a.detail=:detail";
        Query query = em.createQuery(jpql);
        List<User10> users = query.setParameter("detail", "925").getResultList();
        users.forEach(u -> {
            log.debug(u.getName());
        });
    }
}
