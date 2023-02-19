package com.resellerapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class User extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true )
    private String email;

    @OneToMany
    private List<Offer> offers;

    @OneToMany
    private List<Offer> boughtOffers;



}
