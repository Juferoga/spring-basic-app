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

import com.juferoga.recipes.models.UserModel;
import com.juferoga.recipes.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UserController {
  private final UserService userService;

  @GetMapping("")
  public ResponseEntity<List<UserModel>> getAllUsers() {
    return ResponseEntity.ok().body(userService.getAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserModel> getUserById(@PathVariable Long id)
  {
    return ResponseEntity.ok().body(userService.getUserById(id));
  }
  
  @PostMapping("/")
  public ResponseEntity<UserModel> saveUser(@RequestBody UserModel user)
  {
    return ResponseEntity.ok().body(userService.saveUser(user));
  }

  @PutMapping("/")
  public ResponseEntity<UserModel> updateUser(@RequestBody UserModel user)
  {
    return ResponseEntity.ok().body(userService.updateUser(user));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable Long id)
  {
    userService.deleteUser(id);
    return ResponseEntity.ok().body("User deleted successfully");
  }
}
