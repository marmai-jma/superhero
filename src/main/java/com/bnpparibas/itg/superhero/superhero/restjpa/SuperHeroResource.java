package com.bnpparibas.itg.superhero.superhero.restjpa;

import com.bnpparibas.itg.superhero.superhero.mapping.SuperHero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}