package com.juferoga.recipes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.juferoga.recipes.models.IngredientModel;
import com.juferoga.recipes.repositories.IngredientRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class IngredientService {
  private final IngredientRepository ingredientRepository;

  public List<IngredientModel> getAllIngredients() {
    return ingredientRepository.findAll();
  }

  public IngredientModel getIngredientById(Long id) {
    return ingredientRepository.findById(id).orElse(null);
  }

  public IngredientModel saveIngredient(IngredientModel ingredient) {
    return ingredientRepository.save(ingredient);
  }

  public IngredientModel updateIngredient(IngredientModel ingredient) {
    return ingredientRepository.save(ingredient);
  }

  public void deleteIngredient(Long id) {
    ingredientRepository.deleteById(id);
  }
}
