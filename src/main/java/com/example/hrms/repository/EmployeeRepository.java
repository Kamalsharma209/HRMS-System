package com.example.hrms.repository;

import com.example.hrms.module.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Optional<Employee> findByEmpCode(String empCode);

    Optional<Employee> findByUsername(String username);

    Optional<Employee> findByEmail(String email);

    List<Employee> findByActive(boolean active);
}