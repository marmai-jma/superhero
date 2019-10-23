package com.bnpparibas.itg.superhero.superhero.restjpa;

import com.bnpparibas.itg.superhero.superhero.mapping.SuperHero;
import com.bnpparibas.itg.superhero.superhero.mapping.TypeAbility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "superheros")
public interface SuperHeroRepositoryRest extends JpaRepository<SuperHero, Long> {
    List<SuperHero> findByName(@Param("name") String name);

    @Query("SELECT ability.superHeros FROM Ability ability WHERE ability.typeAbility = ?1")
    List<SuperHero> searchByAbility(@Param("typeAbility") TypeAbility typeAbility);
}