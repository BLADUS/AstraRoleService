package com.example.AstraRoleService.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AstraRoleService.Models.Distrib;

@Repository
public interface DistribRepository extends JpaRepository<Distrib, Integer> {

    @Query("SELECT d FROM Distrib d JOIN d.users u WHERE u.id = :userId")
    List<Distrib> findDistribsByUserId(@Param("userId") Integer userId);
}
