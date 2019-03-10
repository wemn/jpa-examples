package com.example.jpaexamples.example04.onetomany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address04 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String detail;
    @ManyToOne
    private User04 user;

    public Address04(String detail) {
        this.detail = detail;
    }

    public Address04(String detail, User04 user) {
        this.detail = detail;
        this.user = user;
    }
}
