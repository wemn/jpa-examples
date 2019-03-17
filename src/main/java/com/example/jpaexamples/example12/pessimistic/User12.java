package com.example.jpaexamples.example12.pessimistic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User12 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int balance;

    public User12(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
}
