package com.example.jpaexamples.example08.casade.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User08 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Address08> addresses;

    public User08(String name) {
        this.name = name;
    }
}
