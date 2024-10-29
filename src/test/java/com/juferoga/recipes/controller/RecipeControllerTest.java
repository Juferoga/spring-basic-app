package com.juferoga.recipes.controller;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.juferoga.recipes.models.RecipeModel;
import com.juferoga.recipes.services.RecipeService;

public class RecipeControllerTest {

    @Mock
    private RecipeService recipeService;

    @InjectMocks
    private RecipeController recipeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllRecipes() {
        RecipeModel recipe1 = new RecipeModel();
        recipe1.setId(1L);
        recipe1.setName("recipe1");

        RecipeModel recipe2 = new RecipeModel();
        recipe2.setId(2L);
        recipe2.setName("recipe2");

        List<RecipeModel> recipeList = Arrays.asList(recipe1, recipe2);

        when(recipeService.getAllRecipes()).thenReturn(recipeList);

        ResponseEntity<List<RecipeModel>> response = recipeController.getAllRecipes();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
        verify(recipeService, times(1)).getAllRecipes();
    }

    @Test
    public void testGetRecipeById() {
        RecipeModel recipe = new RecipeModel();
        recipe.setId(1L);
        recipe.setName("recipe1");

        when(recipeService.getRecipeById(1L)).thenReturn(recipe);

        ResponseEntity<RecipeModel> response = recipeController.getRecipeById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("recipe1", response.getBody().getName());
        verify(recipeService, times(1)).getRecipeById(1L);
    }

    @Test
    public void testSaveRecipe() {
        RecipeModel recipe = new RecipeModel();
        recipe.setId(1L);
        recipe.setName("recipe1");

        when(recipeService.saveRecipe(recipe)).thenReturn(recipe);

        ResponseEntity<RecipeModel> response = recipeController.saveRecipe(recipe);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("recipe1", response.getBody().getName());
        verify(recipeService, times(1)).saveRecipe(recipe);
    }

    @Test
    public void testUpdateRecipe() {
        RecipeModel recipe = new RecipeModel();
        recipe.setId(1L);
        recipe.setName("recipe1");

        when(recipeService.updateRecipe(recipe)).thenReturn(recipe);

        ResponseEntity<RecipeModel> response = recipeController.updateRecipe(recipe);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("recipe1", response.getBody().getName());
        verify(recipeService, times(1)).updateRecipe(recipe);
    }

    @Test
    public void testDeleteRecipe() {
        doNothing().when(recipeService).deleteRecipe(1L);

        ResponseEntity<String> response = recipeController.deleteRecipe(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Recipe deleted successfully", response.getBody());
        verify(recipeService, times(1)).deleteRecipe(1L);
    }
}