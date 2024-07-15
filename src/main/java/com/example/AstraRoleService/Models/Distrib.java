package com.example.AstraRoleService.Models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany(mappedBy = "distribPermissions", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

}
