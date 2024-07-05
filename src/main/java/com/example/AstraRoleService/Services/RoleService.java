package com.example.AstraRoleService.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AstraRoleService.Models.Role;
import com.example.AstraRoleService.Repositories.RoleRepository;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    public void createRole(Role newRole){
        roleRepository.save(newRole);
    }

    public void deleteRole(Integer roleId){
        roleRepository.findById(roleId).ifPresent(roleRepository::delete);
    }
}
