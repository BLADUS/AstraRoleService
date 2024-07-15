package com.example.AstraRoleService.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AstraRoleService.Models.Distrib;
import com.example.AstraRoleService.Repositories.DistribRepository;

@Service
public class DistribService {
    private final DistribRepository distribRepository;

    public DistribService(DistribRepository distribRepository) {
        this.distribRepository = distribRepository;
    }

    public List<Distrib> getDistribsForCurrentUser(Integer userId){
        return distribRepository.findDistribsByUserId(userId);
    }
}
