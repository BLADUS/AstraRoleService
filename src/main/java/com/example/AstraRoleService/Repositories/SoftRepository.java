package com.example.AstraRoleService.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AstraRoleService.Models.Soft;

@Repository
public interface SoftRepository extends JpaRepository<Soft, Integer> {
    @Query("SELECT s FROM Soft s JOIN s.users u WHERE u.id = :userId")
    List<Soft> findSoftsByUserId(@Param("userId") Integer userId);

}
