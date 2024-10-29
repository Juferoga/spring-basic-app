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

import com.juferoga.recipes.models.IngredientModel;
import com.juferoga.recipes.services.IngredientService;

public class IngredientControllerTest {

    @Mock
    private IngredientService ingredientService;

    @InjectMocks
    private IngredientController ingredientController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllIngredients() {
        IngredientModel ingredient1 = new IngredientModel();
        ingredient1.setId(1L);
        ingredient1.setName("ingredient1");

        IngredientModel ingredient2 = new IngredientModel();
        ingredient2.setId(2L);
        ingredient2.setName("ingredient2");

        List<IngredientModel> ingredientList = Arrays.asList(ingredient1, ingredient2);

        when(ingredientService.getAllIngredients()).thenReturn(ingredientList);

        ResponseEntity<List<IngredientModel>> response = ingredientController.getAllIngredients();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
        verify(ingredientService, times(1)).getAllIngredients();
    }

    @Test
    public void testGetIngredientById() {
        IngredientModel ingredient = new IngredientModel();
        ingredient.setId(1L);
        ingredient.setName("ingredient1");

        when(ingredientService.getIngredientById(1L)).thenReturn(ingredient);

        ResponseEntity<IngredientModel> response = ingredientController.getIngredientById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("ingredient1", response.getBody().getName());
        verify(ingredientService, times(1)).getIngredientById(1L);
    }

    @Test
    public void testSaveIngredient() {
        IngredientModel ingredient = new IngredientModel();
        ingredient.setId(1L);
        ingredient.setName("ingredient1");

        when(ingredientService.saveIngredient(ingredient)).thenReturn(ingredient);

        ResponseEntity<IngredientModel> response = ingredientController.saveIngredient(ingredient);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("ingredient1", response.getBody().getName());
        verify(ingredientService, times(1)).saveIngredient(ingredient);
    }

    @Test
    public void testUpdateIngredient() {
        IngredientModel ingredient = new IngredientModel();
        ingredient.setId(1L);
        ingredient.setName("ingredient1");

        when(ingredientService.updateIngredient(ingredient)).thenReturn(ingredient);

        ResponseEntity<IngredientModel> response = ingredientController.updateIngredient(ingredient);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("ingredient1", response.getBody().getName());
        verify(ingredientService, times(1)).updateIngredient(ingredient);
    }

    @Test
    public void testDeleteIngredient() {
        doNothing().when(ingredientService).deleteIngredient(1L);

        ResponseEntity<String> response = ingredientController.deleteIngredient(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Ingredient deleted successfully", response.getBody());
        verify(ingredientService, times(1)).deleteIngredient(1L);
    }
}