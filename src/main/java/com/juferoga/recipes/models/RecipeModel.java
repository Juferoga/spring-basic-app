package com.juferoga.recipes.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "recipe")
public class RecipeModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "description")
  private String description;
  @Column(name = "preparation")
  private String preparation;
  @Column(name = "image")
  private String image;
  // LLave foranea de la tabla de usuarios
  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserModel userId;

  @ManyToMany
  @JoinTable(
    name = "recipe_ingredient",
    joinColumns = @JoinColumn(name = "recipe_id"),
    inverseJoinColumns = @JoinColumn(name = "ingredient_id")
  )
  private Set<IngredientModel> ingredients;
}
