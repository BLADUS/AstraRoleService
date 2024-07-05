package com.example.AstraRoleService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AstraRoleService.Models.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByRoleId(Integer roleId);   
}
