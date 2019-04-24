package com.example.demo.service.impl;

import com.example.demo.dto.request.UserDTO;
import com.example.demo.enums.Role;
import com.example.demo.service.UserService;
import com.google.common.base.Strings;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Override
    public long addUser(UserDTO userDTO) {
        if(Objects.isNull(userDTO)){
            throw new IllegalArgumentException("User DTO is null!");
        }
        validateUserDTO(userDTO);
        return 0;
    }

    private void validateUserDTO(UserDTO userDTO) {
        if(Strings.isNullOrEmpty(userDTO.getUsername())){
            throw new IllegalArgumentException("Username is null or empty!");
        }

        if(Strings.isNullOrEmpty(userDTO.getEmail()) || !EmailValidator.getInstance(true).isValid(userDTO.getEmail())){
            throw new IllegalArgumentException("Email is null, empty or invalid!");
        }

        if(Strings.isNullOrEmpty(userDTO.getRole())){
            throw new IllegalArgumentException("Role is null or empty!");
        }

        if(!userDTO.getRole().equalsIgnoreCase(Role.ADMIN.toString()) && !userDTO.getRole().equalsIgnoreCase(Role.EDITOR.toString())){
            throw new IllegalArgumentException("Inappropriate role!");
        }
    }
}
