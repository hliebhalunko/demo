package com.example.demo.service.impl;

import com.example.demo.dto.request.UserRequestDTO;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Override
    public long addUser(UserRequestDTO userRequestDTO) {
        if(Objects.isNull(userRequestDTO)){
            throw new IllegalArgumentException("User DTO is null!");
        }
        return 0;
    }
}
