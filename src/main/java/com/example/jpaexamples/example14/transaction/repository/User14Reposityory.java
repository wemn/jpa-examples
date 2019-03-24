package com.example.jpaexamples.example14.transaction.repository;

import com.example.jpaexamples.example14.transaction.entity.User14;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User14Reposityory
        extends JpaRepository<User14, Integer> {
}
