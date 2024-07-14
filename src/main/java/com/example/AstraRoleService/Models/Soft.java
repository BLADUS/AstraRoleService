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
@Table(name = "softs")
public class Soft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "soft_id")
    private Integer softId;

    @Column(name = "softname")
    private String softName;
}
