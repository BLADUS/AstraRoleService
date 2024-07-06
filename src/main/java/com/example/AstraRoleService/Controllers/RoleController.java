package com.example.AstraRoleService.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AstraRoleService.Models.Role;
import com.example.AstraRoleService.Models.User;
import com.example.AstraRoleService.Services.RoleService;
import com.example.AstraRoleService.Services.UserService;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;
    private final UserService userService;

    public RoleController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PostMapping
    public void createRole(@RequestBody Role newRole) {
        roleService.saveRole(newRole);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable("id") Integer roleId) {
        roleService.deleteRole(roleId);
    }

    @GetMapping("/affected-users/{roleId}")
    public List<User> getAffectedUsers(@PathVariable("roleId") Integer roleId) {
        return userService.getAllUsersByRoleId(roleId);
    }

    @PatchMapping
    public void updateRole(@RequestBody Role changedRole){
        roleService.saveRole(changedRole);
    }

}