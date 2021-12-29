package com.example.vetapplication.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.vetapplication.model.User;
import com.example.vetapplication.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}
