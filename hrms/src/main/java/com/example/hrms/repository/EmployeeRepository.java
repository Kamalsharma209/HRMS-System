package com.example.hrms.repository;

import com.example.hrms.module.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository
        extends MongoRepository<Employee, String> {

    Optional<Employee> findByEmpCode(String empCode);
    List<Employee> findByActive(boolean active);
}
