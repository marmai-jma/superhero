package com.bnpparibas.itg.superhero.superhero.mapping;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Costume {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private boolean cape;

    @Column
    private boolean belt;

    @Column
    private boolean hat;

    @Enumerated(EnumType.STRING)
    @Column
    private Color color;

    private Costume() {}

    public Costume(boolean cape, boolean belt, boolean hat, Color color) {
        this.cape = cape;
        this.belt = belt;
        this.hat = hat;
        this.color = color;
    }
}