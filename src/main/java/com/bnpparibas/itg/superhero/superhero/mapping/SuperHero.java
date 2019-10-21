package com.bnpparibas.itg.superhero.superhero.mapping;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "superhero_has_abilities",
            joinColumns = @JoinColumn(name = "superhero_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    private List<Ability> abilities;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="SUPER_HERO_ID", referencedColumnName = "ID")
    private List<Enemy> enemies;

    private SuperHero() {}

}