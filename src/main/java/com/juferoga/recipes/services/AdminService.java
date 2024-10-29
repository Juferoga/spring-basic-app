package com.juferoga.recipes.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juferoga.recipes.models.AdminModel;
import com.juferoga.recipes.repositories.AdminRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {
  private final AdminRepository adminRepository;

  @Transactional(readOnly = true)
  public List<AdminModel> getAllAdmins() {
    return adminRepository.findAll();
  }

  @Transactional(readOnly = true)
  public AdminModel getAdminById(Long id) {
    return adminRepository.findById(id).orElse(null);
  }

  public AdminModel saveAdmin(AdminModel admin) {
    return adminRepository.save(admin);
  }

  public AdminModel updateAdmin(AdminModel admin) {
    return adminRepository.save(admin);
  }

  public void deleteAdmin(Long id) {
    adminRepository.deleteById(id);
  }
}
