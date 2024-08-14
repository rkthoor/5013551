package com.example.employeemanagementsystem.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "employees")
@Data
public class Employee extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private Boolean deleted = false;  // Soft delete flag
}

