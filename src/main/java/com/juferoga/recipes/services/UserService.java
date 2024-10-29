package com.juferoga.recipes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.juferoga.recipes.models.UserModel;
import com.juferoga.recipes.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
  private final UserRepository userRepository;

  public List<UserModel> getAllUsers() {
    return userRepository.findAll();
  }

  public UserModel getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  public UserModel saveUser(UserModel user) {
    return userRepository.save(user);
  }

  public UserModel updateUser(UserModel user) {
    return userRepository.save(user);
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
