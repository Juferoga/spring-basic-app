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

import com.juferoga.recipes.models.UserModel;
import com.juferoga.recipes.services.UserService;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        UserModel user1 = new UserModel();
        user1.setId(1L);
        user1.setName("user1");

        UserModel user2 = new UserModel();
        user2.setId(2L);
        user2.setName("user2");

        List<UserModel> userList = Arrays.asList(user1, user2);

        when(userService.getAllUsers()).thenReturn(userList);

        ResponseEntity<List<UserModel>> response = userController.getAllUsers();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    public void testGetUserById() {
        UserModel user = new UserModel();
        user.setId(1L);
        user.setName("user1");

        when(userService.getUserById(1L)).thenReturn(user);

        ResponseEntity<UserModel> response = userController.getUserById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("user1", response.getBody().getName());
        verify(userService, times(1)).getUserById(1L);
    }

    @Test
    public void testSaveUser() {
        UserModel user = new UserModel();
        user.setId(1L);
        user.setName("user1");

        when(userService.saveUser(user)).thenReturn(user);

        ResponseEntity<UserModel> response = userController.saveUser(user);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("user1", response.getBody().getName());
        verify(userService, times(1)).saveUser(user);
    }

    @Test
    public void testUpdateUser() {
        UserModel user = new UserModel();
        user.setId(1L);
        user.setName("user1");

        when(userService.updateUser(user)).thenReturn(user);

        ResponseEntity<UserModel> response = userController.updateUser(user);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("user1", response.getBody().getName());
        verify(userService, times(1)).updateUser(user);
    }

    @Test
    public void testDeleteUser() {
        doNothing().when(userService).deleteUser(1L);

        ResponseEntity<String> response = userController.deleteUser(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("User deleted successfully", response.getBody());
        verify(userService, times(1)).deleteUser(1L);
    }
}