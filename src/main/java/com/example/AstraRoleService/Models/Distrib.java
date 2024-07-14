package com.example.AstraRoleService.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "distribs")
public class Distrib {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "distrib_id")
    private Integer distribId;

    @Column(name = "distribname")
    private String distribName;
}

