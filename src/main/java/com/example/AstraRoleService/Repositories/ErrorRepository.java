package com.example.AstraRoleService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AstraRoleService.Models.Error;

@Repository
public interface ErrorRepository extends JpaRepository<Error, Integer> {
}
