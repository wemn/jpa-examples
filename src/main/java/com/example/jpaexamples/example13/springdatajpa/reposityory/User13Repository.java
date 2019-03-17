package com.example.jpaexamples.example13.springdatajpa.reposityory;

import com.example.jpaexamples.example13.springdatajpa.entity.User13;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User13Repository
        extends JpaRepository<User13, Integer>,
        CustomizedRepoistory<User13, Integer> {

    @Query("SELECT u FROM #{#entityName} u WHERE u.address=:address")
    List<User13> list(@Param("address") String address);
    List<User13> findByAddress(String address);

}
