package com.example.AstraRoleService.Services;

import org.springframework.stereotype.Service;

import com.example.AstraRoleService.Repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
