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

import com.juferoga.recipes.models.IngredientModel;
import com.juferoga.recipes.services.IngredientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ingredient")
@RequiredArgsConstructor
@Validated
public class IngredientController {
  private final IngredientService ingredientService;

  @GetMapping("")
  public ResponseEntity<List<IngredientModel>> getAllIngredients() {
    return ResponseEntity.ok().body(ingredientService.getAllIngredients());
  }

  @GetMapping("/{id}")
  public ResponseEntity<IngredientModel> getIngredientById(@PathVariable Long id)
  {
    return ResponseEntity.ok().body(ingredientService.getIngredientById(id));
  }
  
  @PostMapping("/")
  public ResponseEntity<IngredientModel> saveIngredient(@RequestBody IngredientModel ingredient)
  {
    return ResponseEntity.ok().body(ingredientService.saveIngredient(ingredient));
  }

  @PutMapping("/")
  public ResponseEntity<IngredientModel> updateIngredient(@RequestBody IngredientModel ingredient)
  {
    return ResponseEntity.ok().body(ingredientService.updateIngredient(ingredient));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteIngredient(@PathVariable Long id)
  {
    ingredientService.deleteIngredient(id);
    return ResponseEntity.ok().body("Ingredient deleted successfully");
  }
}
