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
    private boolean belt;
    @Column
    private boolean cape;
    @Enumerated(EnumType.STRING)
    @Column
    private Color color;
    @Column
    private boolean hat;

    private Costume() {};

    public Costume(boolean belt, boolean cape, Color color, boolean hat) {
        this.belt = belt;
        this.cape = cape;
        this.color = color;
        this.hat = hat;
    }
}
