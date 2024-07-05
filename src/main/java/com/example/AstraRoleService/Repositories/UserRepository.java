package com.example.AstraRoleService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AstraRoleService.Models.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByRoleId(Integer roleId);

    @Modifying
    @Query("UPDATE User u SET u.roleId = 1 WHERE u.roleId = :roleId")
    void updateUserRolesToDefault(@Param("roleId") Integer roleId);
}
