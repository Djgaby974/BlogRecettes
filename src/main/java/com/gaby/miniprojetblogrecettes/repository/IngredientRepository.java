package com.gaby.miniprojetblogrecettes.repository;

import com.gaby.miniprojetblogrecettes.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}