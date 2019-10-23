package com.bnpparibas.itg.superhero.superhero.mapping;

import lombok.Getter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class SuperHero {

    @Id
    @GeneratedValue
    private Long id;

    private SuperHero() {}
}
