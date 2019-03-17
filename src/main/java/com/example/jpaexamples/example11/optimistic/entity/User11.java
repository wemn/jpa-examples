package com.example.jpaexamples.example11.optimistic.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter@Setter
@NoArgsConstructor
@Entity
public class User11 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Version
    private int version;

    public User11(String name) {
        this.name = name;
    }
}
