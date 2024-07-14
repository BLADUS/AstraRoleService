package com.example.AstraRoleService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AstraRoleService.Models.Soft;

@Repository
public interface SoftRepository extends JpaRepository<Soft, Integer> {
}