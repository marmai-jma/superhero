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
    private String secret_identity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "costume_id")
    private Costume costume;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "superhero_has_abilities",
            joinColumns = @JoinColumn(name = "superhero_id"),
            inverseJoinColumns = @JoinColumn(name = "ability")
    )
    private Set<Ability> abilities;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "super_hero_id")
    private Set<Enemy> enemies;

    private SuperHero() {}

    public SuperHero(String name, String secret_identity, Costume costume, Set<Ability> abilities, Set<Enemy> enemies) {
        this.name = name;
        this.secret_identity = secret_identity;
        this.costume = costume;
        this.abilities = abilities;
        this.enemies = enemies;
    }
}
