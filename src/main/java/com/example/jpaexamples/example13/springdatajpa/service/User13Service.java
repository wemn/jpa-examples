package com.example.jpaexamples.example13.springdatajpa.service;

import com.example.jpaexamples.example13.springdatajpa.entity.User13;
import com.example.jpaexamples.example13.springdatajpa.reposityory.User13Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class User13Service {
    @Autowired
    private User13Repository userRep;
    public User13 addUser(User13 u) {
        return userRep.save(u);
    }

    public User13 addUser2(User13 u) {
        User13 user = userRep.save(u);
        userRep.refresh(user);
        return user;
    }

    public User13 updateUser(int id, String newName) {
        User13 u = userRep.findById(id).get();
        u.setName(newName);
        return userRep.save(u);
    }

    public List<User13> listUser(String address) {
        return userRep.list(address);
    }

    public List<User13> listUser2(String address) {
        return userRep.findByAddress("956");
    }
}

