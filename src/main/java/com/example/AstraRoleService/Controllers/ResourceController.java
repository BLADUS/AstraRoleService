package com.example.AstraRoleService.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AstraRoleService.Models.Distrib;
import com.example.AstraRoleService.Models.Soft;
import com.example.AstraRoleService.Services.DistribService;
import com.example.AstraRoleService.Services.ErrorService;
import com.example.AstraRoleService.Services.SoftService;
import com.example.AstraRoleService.Models.Error;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    private final ErrorService errorService;
    private final DistribService distribService;
    private final SoftService softService;

    public ResourceController(ErrorService errorService, DistribService distribService, SoftService softService) {
        this.errorService = errorService;
        this.distribService = distribService;
        this.softService = softService;
    }

    @GetMapping("/errors")
    public ResponseEntity<?> getAllErrors() {
        try {
            List<Error> errors = errorService.getAllErrors();
            return createResponse(errors);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while retrieving the list of errors");
        }
    }

    @GetMapping("/distribs")
    public ResponseEntity<?> getAllDistribs() {
        try {
            List<Distrib> distribs = distribService.getAllDistribs();
            return createResponse(distribs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while retrieving the list of distribs");
        }
    }

    @GetMapping("/softs")
    public ResponseEntity<?> getAllSofts() {
        try {
            List<Soft> softs = softService.getAllSofts();
            return createResponse(softs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while retrieving the list of softs");
        }
    }

    private ResponseEntity<?> createResponse(List<?> data) {
        if (data.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(data);
        }
    }
}
