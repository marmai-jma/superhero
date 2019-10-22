package com.bnpparibas.itg.superhero.superhero.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SuperHero {

    @Id
    @GeneratedValue
    private Long id;

    private SuperHero() {}
}