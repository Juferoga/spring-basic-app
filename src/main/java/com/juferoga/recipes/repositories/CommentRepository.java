package com.juferoga.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juferoga.recipes.models.CommentModel;

// Repository interface for Comment model
public interface CommentRepository extends JpaRepository<CommentModel, Long> {
    
}
