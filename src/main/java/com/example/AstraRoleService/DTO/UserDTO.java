package com.example.AstraRoleService.DTO;

import com.example.AstraRoleService.Models.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private Integer userId;
    private String username;
    private Integer roleId;
    private Float weight;

    public UserDTO(User user){
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.roleId = user.getRoleId();
        this.weight = user.getWeight();
    }
}
