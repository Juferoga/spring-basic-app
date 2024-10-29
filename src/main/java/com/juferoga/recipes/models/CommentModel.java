package com.juferoga.recipes.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "commentaries")
public class CommentModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Long id;
  @Column(name="comment",nullable = false)
  private String comment;
  @Column(name="date",nullable = false)
  private Date date;
  
  @ManyToOne
  @JoinColumn(name = "recipe_id")
  private RecipeModel recipeId;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserModel userId;
}
