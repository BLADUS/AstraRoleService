package com.example.AstraRoleService.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AstraRoleService.Exctptions.NotFoundException;
import com.example.AstraRoleService.Models.Role;
import com.example.AstraRoleService.Repositories.RoleRepository;
import com.example.AstraRoleService.Repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public RoleService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Integer roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new NotFoundException("Роль с roleId:" + roleId + "не найдена."));
    }
    

    public void saveRole(Role newRole) {
        roleRepository.save(newRole);
    }

    @Transactional
    public void deleteRole(Integer roleId) {
        if (roleId.equals(1) || roleId.equals(2)) {
            throw new IllegalArgumentException("Данную роль удалить нельзя");
        }

        userRepository.updateUserRolesToDefault(roleId);
        roleRepository.findById(roleId).ifPresent(roleRepository::delete);
    }
}
