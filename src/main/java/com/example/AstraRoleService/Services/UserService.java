package com.example.AstraRoleService.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AstraRoleService.Models.User;
import com.example.AstraRoleService.Repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getAllUsersByRoleId(Integer roleId) {
        return userRepository.findByRoleId(roleId);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

}
