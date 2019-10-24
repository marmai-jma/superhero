package com.bnpparibas.itg.superhero.superhero.mapping;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
@Getter
@Entity
public class Ability {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private TypeAbility typeAbility;

    @Column
    private String description;

    @ManyToMany(mappedBy = "abilities")
    private Set<SuperHero> superHeros;

    private Ability() {}

    public Ability(TypeAbility typeAbility, String description, Set<SuperHero> superHeros) {
        this.typeAbility = typeAbility;
        this.description = description;
        this.superHeros = superHeros;
    }
}