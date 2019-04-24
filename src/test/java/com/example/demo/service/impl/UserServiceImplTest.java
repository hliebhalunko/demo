package com.example.demo.service.impl;

import com.example.demo.dto.request.UserDTO;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserDTO userDTO;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void addUser_exceptionThrownIfDTONotExists() {

        exceptionRule.expect(IllegalArgumentException.class);

        userService.addUser(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateUserDTO_exceptionThrownIfUserNameIsNullOrEmpty() {

        userService.addUser(userDTO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateUserDTO_exceptionThrownIfEmailIsNullOrEmpty() {

        when(userDTO.getUsername()).thenReturn("testname");

        userService.addUser(userDTO);

    }

    @Test(expected = IllegalArgumentException.class)
    public void validateUserDTO_exceptionThrownIfEmailIsInvalid() {

        when(userDTO.getUsername()).thenReturn("testname");
        when(userDTO.getEmail()).thenReturn("invalidemail");

        userService.addUser(userDTO);

    }

    @Test
    public void validateUserDTO_testValidEmail() {

        when(userDTO.getUsername()).thenReturn("testname");
        when(userDTO.getEmail()).thenReturn("validemail@gmail.com");
        when(userDTO.getRole()).thenReturn("admin");

        userService.addUser(userDTO);

    }

    @Test(expected = IllegalArgumentException.class)
    public void validateUserDTO_exceptionThrownIfUserRoleIsNull() {

        when(userDTO.getUsername()).thenReturn("testname");
        when(userDTO.getEmail()).thenReturn("validemail@gmail.com");

        userService.addUser(userDTO);

    }

    @Test(expected = IllegalArgumentException.class)
    public void validateUserDTO_exceptionThrownIfUserHasInappropriateRole() {

        when(userDTO.getUsername()).thenReturn("testname");
        when(userDTO.getEmail()).thenReturn("validemail@gmail.com");
        when(userDTO.getRole()).thenReturn("other");

        userService.addUser(userDTO);

    }

    @Test
    public void validateUserDTO_testValidRole() {

        when(userDTO.getUsername()).thenReturn("testname");
        when(userDTO.getEmail()).thenReturn("validemail@gmail.com");
        when(userDTO.getRole()).thenReturn("admin");

        userService.addUser(userDTO);

    }

}
