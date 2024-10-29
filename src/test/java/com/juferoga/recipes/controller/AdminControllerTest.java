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

import com.juferoga.recipes.models.AdminModel;
import com.juferoga.recipes.services.AdminService;

public class AdminControllerTest {

    @Mock
    private AdminService userService;

    @InjectMocks
    private AdminController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllAdmins() {
        AdminModel user1 = new AdminModel();
        user1.setId(1L);
        user1.setUsername("user1");

        AdminModel user2 = new AdminModel();
        user2.setId(2L);
        user2.setUsername("user2");

        List<AdminModel> userList = Arrays.asList(user1, user2);

        when(userService.getAllAdmins()).thenReturn(userList);

        ResponseEntity<List<AdminModel>> response = userController.getAllAdmins();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
        verify(userService, times(1)).getAllAdmins();
    }

    @Test
    public void testGetAdminById() {
        AdminModel user = new AdminModel();
        user.setId(1L);
        user.setUsername("user1");

        when(userService.getAdminById(1L)).thenReturn(user);

        ResponseEntity<AdminModel> response = userController.getAdminById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("user1", response.getBody().getUsername());
        verify(userService, times(1)).getAdminById(1L);
    }

    @Test
    public void testSaveAdmin() {
        AdminModel user = new AdminModel();
        user.setId(1L);
        user.setUsername("user1");

        when(userService.saveAdmin(user)).thenReturn(user);

        ResponseEntity<AdminModel> response = userController.saveAdmin(user);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("user1", response.getBody().getUsername());
        verify(userService, times(1)).saveAdmin(user);
    }

    @Test
    public void testUpdateAdmin() {
        AdminModel user = new AdminModel();
        user.setId(1L);
        user.setUsername("user1");

        when(userService.updateAdmin(user)).thenReturn(user);

        ResponseEntity<AdminModel> response = userController.updateAdmin(user);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("user1", response.getBody().getUsername());
        verify(userService, times(1)).updateAdmin(user);
    }

    @Test
    public void testDeleteAdmin() {
        doNothing().when(userService).deleteAdmin(1L);

        ResponseEntity<String> response = userController.deleteAdmin(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Admin deleted successfully", response.getBody());
        verify(userService, times(1)).deleteAdmin(1L);
    }
}