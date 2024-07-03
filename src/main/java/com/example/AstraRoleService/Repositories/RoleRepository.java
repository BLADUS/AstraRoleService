package com.example.AstraRoleService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AstraRoleService.Models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
