package com.juferoga.recipes.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juferoga.recipes.models.RecipeModel;
import com.juferoga.recipes.repositories.RecipeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeService {
  private final RecipeRepository recipeRepository;

  @Transactional(readOnly = true)
  public List<RecipeModel> getAllRecipes() {
    List<RecipeModel> recipes = recipeRepository.findAll();
    // Inicializa las colecciones perezosas >:v
    for (RecipeModel recipe : recipes) {
      recipe.getIngredients().size();
    }
    return recipes;
  }

  @Transactional(readOnly = true)
  public RecipeModel getRecipeById(Long id) {
    RecipeModel recipe = recipeRepository.findById(id).orElse(null);
    if (recipe != null) {
      // Inicializa las colecciones perezosas >:v
      recipe.getIngredients().size();
    }
    return recipe;
  }

  public RecipeModel saveRecipe(RecipeModel recipe) {
    return recipeRepository.save(recipe);
  }

  public RecipeModel updateRecipe(RecipeModel recipe) {
    return recipeRepository.save(recipe);
  }

  public void deleteRecipe(Long id) {
    recipeRepository.deleteById(id);
  }
}
