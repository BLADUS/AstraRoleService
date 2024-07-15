package com.example.AstraRoleService.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AstraRoleService.DTO.UserDTO;
import com.example.AstraRoleService.Models.User;
import com.example.AstraRoleService.Services.RoleService;
import com.example.AstraRoleService.Services.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        try {
            List<User> listRole = userService.getAllUsers();
            if (listRole.isEmpty()) {
                return new ResponseEntity<>("User list is empty", HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(listRole, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while retrieving the list of users",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/set-user/{userId}")
    public ResponseEntity<?> setSessionUser(@PathVariable("userId") Integer userId, HttpServletRequest request) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        HttpSession session = request.getSession();
        session.setAttribute("sessionUser", user);
        session.setAttribute("sessionRole", roleService.getRoleById(user.getRoleId()));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/session-user")
    public ResponseEntity<UserDTO> getSessionUser(HttpServletRequest request) {
        User sessionUser = (User) request.getSession().getAttribute("sessionUser");
        if (sessionUser == null) {
            return ResponseEntity.notFound().build();
        }
        UserDTO userDTO = new UserDTO(sessionUser);
        return ResponseEntity.ok(userDTO);
    }


}