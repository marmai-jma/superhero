package com.bnpparibas.itg.superhero.superhero.mapping;

import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
public class SuperHero {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String secretIdentity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "costume_id")
    private Costume costume;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "superhero_has_abilities",
            joinColumns = @JoinColumn(name = "superhero_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    private Set<Ability> abilities;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="SUPER_HERO_ID")
    private Set<Enemy> enemies;

    private SuperHero() {}

}