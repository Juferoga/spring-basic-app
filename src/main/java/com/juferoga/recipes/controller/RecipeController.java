package com.juferoga.recipes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juferoga.recipes.models.RecipeModel;
import com.juferoga.recipes.services.RecipeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/recipe")
@RequiredArgsConstructor
@Validated
public class RecipeController {
  private final RecipeService recipeService;

  @GetMapping("")
  public ResponseEntity<List<RecipeModel>> getAllRecipes() {
    return ResponseEntity.ok().body(recipeService.getAllRecipes());
  }

  @GetMapping("/{id}")
  public ResponseEntity<RecipeModel> getRecipeById(@PathVariable Long id)
  {
    return ResponseEntity.ok().body(recipeService.getRecipeById(id));
  }
  
  @PostMapping("/")
  public ResponseEntity<RecipeModel> saveRecipe(@RequestBody RecipeModel recipe)
  {
    return ResponseEntity.ok().body(recipeService.saveRecipe(recipe));
  }

  @PutMapping("/")
  public ResponseEntity<RecipeModel> updateRecipe(@RequestBody RecipeModel recipe)
  {
    return ResponseEntity.ok().body(recipeService.updateRecipe(recipe));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteRecipe(@PathVariable Long id)
  {
    recipeService.deleteRecipe(id);
    return ResponseEntity.ok().body("Recipe deleted successfully");
  }
}
