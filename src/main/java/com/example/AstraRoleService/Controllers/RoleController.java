package com.example.AstraRoleService.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import jakarta.servlet.http.HttpServletRequest;

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
    public ResponseEntity<String> createRole(@RequestBody Role newRole, HttpServletRequest request) {
        Role sessionRole = (Role) request.getSession().getAttribute("sessionRole");
        if (sessionRole.getCreate_roles()) {
            roleService.saveRole(newRole);
            return ResponseEntity.ok("Role created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You do not have permission to create roles");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable("id") Integer roleId, HttpServletRequest request) {
        Role sessionRole = (Role) request.getSession().getAttribute("sessionRole");
        if (sessionRole.getDelete_roles()) {
            roleService.deleteRole(roleId);
            return ResponseEntity.ok("Role deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You do not have permission to delete roles");
        }
    }

    @GetMapping("/affected-users/{roleId}")
    public List<User> getAffectedUsers(@PathVariable("roleId") Integer roleId) {
        return userService.getAllUsersByRoleId(roleId);
    }

    @PatchMapping
    public ResponseEntity<String> updateRole(@RequestBody Role changedRole, HttpServletRequest request) {
        Role sessionRole = (Role) request.getSession().getAttribute("sessionRole");
        if (sessionRole.getEdit_roles()) {
            roleService.saveRole(changedRole);
            return ResponseEntity.ok("Role updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You do not have permission to edit roles");
        }
    }

    @PostMapping("/set-role/{roleId}")
    public ResponseEntity<?> setSessionRole(@PathVariable("roleId") Integer roleId, HttpServletRequest request) {
        Role role = roleService.getRoleById(roleId);
        if (role == null) {
            return ResponseEntity.notFound().build();
        }
        request.getSession().setAttribute("sessionRole", role);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/session-role")
    public ResponseEntity<Role> getSessionRole(HttpServletRequest request) {
        Role sessionRole = (Role) request.getSession().getAttribute("sessionRole");
        if (sessionRole == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sessionRole);
    }
}
