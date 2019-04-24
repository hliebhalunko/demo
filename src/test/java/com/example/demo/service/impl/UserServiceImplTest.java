package com.example.demo.service.impl;

import com.example.demo.dto.request.UserDTO;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

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

        UserDTO userRequestDTO = new UserDTO();
        userService.addUser(userRequestDTO);
    }

}
