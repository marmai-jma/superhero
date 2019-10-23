package com.bnpparibas.itg.superhero.superhero.mapping;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;

import javax.persistence.*;

@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
@Getter
@Entity
public class Enemy {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private SuperHero superHero;

    private Enemy() {}
}