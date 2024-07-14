package com.example.AstraRoleService.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AstraRoleService.Models.Soft;
import com.example.AstraRoleService.Repositories.SoftRepository;

@Service
public class SoftService {
    private final SoftRepository softRepository;

    public SoftService(SoftRepository softRepository) {
        this.softRepository = softRepository;
    }

    public List<Soft> getAllSofts() {
        return softRepository.findAll();
    }
}
