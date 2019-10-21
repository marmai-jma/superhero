package com.bnpparibas.itg.superhero.superhero.mapping;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Enemy {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nom;

    @ManyToOne(cascade = CascadeType.ALL)
    private SuperHero superHero;

    private Enemy() {}
}