package com.example.jpaexamples.example07.objectstates;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
@Slf4j
public class User07Repository {
    @PersistenceContext
    private EntityManager em;
    public void persist1() {
        User07 u = new User07("BO");
        em.persist(u);
        u.setName("SUN");
        em.persist(u);
        log.debug(u.getName());
    }

    public User07 persist2(User07 u) {
        em.persist(u);
        return u;
    }

    public void find1() {
        User07 u1 = em.find(User07.class, 1);
        log.debug(u1.getName());
        User07 u2 = em.find(User07.class, 1);
        log.debug("" + (u1 == u2));
    }

    public void flush1() {
        User07 user = new User07("BO");
        em.persist(user);
        user.setName("SUN");
        em.flush();
        log.debug(user.getName());
    }

    public void refresh1() {
        User07 user = new User07("BO");
        em.persist(user);
        log.debug("" + user.getInsertTime());
        em.refresh(user);
        log.debug("" + user.getInsertTime());
    }

    public void merge1() {
        User07 user = new User07();
        user.setId(1);
        // merge()，返回的对象为修改后的，受管对象，但此时所有属性数据都是null
        User07 u = em.merge(user);
        // refresh()，从数据库更新数据至受管对象覆盖null数据
        em.refresh(u);
        // 更新受管对象属性数据，自动完成同步
        u.setName("SUN");
    }

    public void merge2(){
        User07 user = em.find(User07.class, 1);
        user.setName("SUN");
        em.merge(user);
    }
}
