package com.juferoga.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juferoga.recipes.models.UserModel;

// Repository interface for User model
public interface UserRepository extends JpaRepository<UserModel, Long> {
    
}
