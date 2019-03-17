package com.example.jpaexamples.example11.optimistic.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address11 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String detail;
    @Version
    private LocalDateTime updateTime;

    public Address11(String detail) {
        this.detail = detail;
    }
}
