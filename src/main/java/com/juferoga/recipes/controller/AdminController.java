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

import com.juferoga.recipes.models.AdminModel;
import com.juferoga.recipes.services.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user/admin")
@RequiredArgsConstructor
@Validated
public class AdminController {
  private final AdminService adminService;

  @GetMapping("")
  public ResponseEntity<List<AdminModel>> getAllAdmins() {
    return ResponseEntity.ok().body(adminService.getAllAdmins());
  }

  @GetMapping("/{id}")
  public ResponseEntity<AdminModel> getAdminById(@PathVariable Long id)
  {
    return ResponseEntity.ok().body(adminService.getAdminById(id));
  }
  
  @PostMapping("/")
  public ResponseEntity<AdminModel> saveAdmin(@RequestBody AdminModel admin)
  {
    return ResponseEntity.ok().body(adminService.saveAdmin(admin));
  }

  @PutMapping("/")
  public ResponseEntity<AdminModel> updateAdmin(@RequestBody AdminModel admin)
  {
    return ResponseEntity.ok().body(adminService.updateAdmin(admin));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteAdmin(@PathVariable Long id)
  {
    adminService.deleteAdmin(id);
    return ResponseEntity.ok().body("Admin deleted successfully");
  }
}
