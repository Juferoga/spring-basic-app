package com.juferoga.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juferoga.recipes.models.IngredientModel;

// Repository interface for Ingredient model
public interface IngredientRepository extends JpaRepository<IngredientModel, Long> {
    
}
