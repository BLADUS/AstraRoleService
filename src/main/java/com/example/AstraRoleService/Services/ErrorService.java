package com.example.AstraRoleService.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AstraRoleService.Models.Error;
import com.example.AstraRoleService.Repositories.ErrorRepository;

@Service
public class ErrorService {
    private final ErrorRepository errorRepository;

    public ErrorService(ErrorRepository errorRepository) {
        this.errorRepository = errorRepository;
    }

    public List<Error> getAllErrors(){
        return errorRepository.findAll();
    }
} 
