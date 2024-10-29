package com.juferoga.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juferoga.recipes.models.AdminModel;

// Repository interface for Admin model
public interface AdminRepository extends JpaRepository<AdminModel, Long> {
    
}
