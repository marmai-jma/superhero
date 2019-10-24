package com.bnpparibas.itg.superhero.superhero.restjpa;

import com.bnpparibas.itg.superhero.superhero.mapping.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class SuperHeroResource {

    @Autowired
    private SuperHeroRepositoryRest superHeroRepositoryRest;

    @RequestMapping(method = RequestMethod.GET, path = {"/shs/{id}"})
    public SuperHero detailSH(@PathVariable("id") Long id) {
        SuperHero sh = superHeroRepositoryRest.findOne(id);
        return sh;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/shs/"})
    public List<SuperHero> findAll() {
        return superHeroRepositoryRest.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/shs/init"})
    public void initManyToMany() {
        Costume c1 = new Costume(true, true, true, Color.BLUE);
        Set<Enemy> e1 = new HashSet<>(Arrays.asList(new Enemy("e1", null)));
        Set<Ability> a1 = new HashSet<>(Arrays.asList(new Ability(TypeAbility.RUN_FAST, "RUNNNNN", null)));

        SuperHero sh1 = new SuperHero("sh1", "sh1", c1, a1, e1);

        superHeroRepositoryRest.save(sh1);

        Set<Enemy> e2 = new HashSet<>(Arrays.asList(new Enemy("e2", null)));
        SuperHero sh2 = new SuperHero("sh2", "sh2", c1, a1, e2);

        superHeroRepositoryRest.save(sh2);

        Set<Enemy> e3 = new HashSet<>(Arrays.asList(new Enemy("e3", null)));
        Set<Ability> a3 = new HashSet<>(Arrays.asList(new Ability(TypeAbility.FLY, "FLYYYY", null)));
        SuperHero sh3 = new SuperHero("sh3", "sh3", c1, a3, e3);

        superHeroRepositoryRest.save(sh3);
    }
}