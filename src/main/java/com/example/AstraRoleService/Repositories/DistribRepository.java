package com.example.AstraRoleService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AstraRoleService.Models.Distrib;

@Repository
public interface DistribRepository extends JpaRepository<Distrib, Integer> {

}
