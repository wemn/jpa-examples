package com.example.jpaexamples.example08.casade.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address08 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String detail;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User08 user;

    public Address08(String detail) {
        this.detail = detail;
    }
}
