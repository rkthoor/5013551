package com.example.employeemanagementsystem.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "departments")
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;
}

