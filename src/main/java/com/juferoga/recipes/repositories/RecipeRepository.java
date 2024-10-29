package com.juferoga.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juferoga.recipes.models.RecipeModel;

// Repository interface for Recipe model
public interface RecipeRepository extends JpaRepository<RecipeModel, Long> {
    
}
