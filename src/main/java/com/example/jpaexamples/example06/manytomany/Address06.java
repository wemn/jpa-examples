package com.example.jpaexamples.example06.manytomany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address06 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String detail;
    @OneToMany(mappedBy = "address")
    private List<UserAddress06> userAddresses;

    public Address06(String detail) {
        this.detail = detail;
    }
}
