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
    public void exceptionThrownIfDTONotExists(){

        exceptionRule.expect(IllegalArgumentException.class);

        userService.addUser(null);
    }

    @Test
    public void exceptionThrownIfUserNameIsNullOrEmpty(){

        exceptionRule.expect(IllegalArgumentException.class);

        userService.addUser(userDTO);
    }

    @Test
    public void exceptionThrownIfEmailIsNullOrEmpty(){

        exceptionRule.expect(IllegalArgumentException.class);

        when(userDTO.getUsername()).thenReturn("testname");

        userService.addUser(userDTO);

    }

    @Test
    public void exceptionThrownIfEmailIsInvalid(){

        exceptionRule.expect(IllegalArgumentException.class);

        when(userDTO.getUsername()).thenReturn("testname");
        when(userDTO.getEmail()).thenReturn("invalidemail");

        userService.addUser(userDTO);

    }

    @Test
    public void testValidEmail(){

        when(userDTO.getUsername()).thenReturn("testname");
        when(userDTO.getEmail()).thenReturn("validemail@gmail.com");

        userService.addUser(userDTO);

    }

}
