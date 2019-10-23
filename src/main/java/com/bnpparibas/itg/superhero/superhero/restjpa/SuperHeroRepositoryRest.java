package com.bnpparibas.itg.superhero.superhero.restjpa;

import com.bnpparibas.itg.superhero.superhero.mapping.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "superheros")
public interface SuperHeroRepositoryRest extends JpaRepository<SuperHero, Long> {}
