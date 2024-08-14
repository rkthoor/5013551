package com.example.employeemanagementsystem.repository;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e.id AS id, e.name AS name, e.email AS email FROM Employee e")
    List<EmployeeProjection> findEmployeeProjections();

    @Query("SELECT e.id AS id, e.name AS name, e.email AS email FROM Employee e WHERE e.department.id = :departmentId")
    List<EmployeeProjection> findEmployeeProjectionsByDepartmentId(Long departmentId);

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);
}

