package com.bnpparibas.itg.superhero.superhero.mapping;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Ability {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private TypeAbility typeAbility;

    @ManyToMany(mappedBy = "abilities")
    private List<SuperHero> superHeros;

    private Ability() {}
}