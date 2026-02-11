package com.example.hrms.service;

import com.example.hrms.module.Employee;
import com.example.hrms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    @Autowired
    public EmployeeService(EmployeeRepository repo){
        this.repo = repo;
    }

    public Employee save(Employee e){
        return repo.save(e);
    }

    public Employee findByCode(String code){
        return repo.findByEmpCode(code).orElse(null);
    }

    public List<Employee> all(){
        return repo.findAll();
    }

    public void deactivate(String code){
        Employee e = findByCode(code);
        if(e != null){
            e.setActive(false);
            repo.save(e);
        }
    }

    public List<Employee> getActive(){
        return repo.findByActive(true);
    }

    public List<Employee> getInactive(){
        return repo.findByActive(false);
    }

    public void activate(String code){
        Employee e = findByCode(code);
        if(e != null){
            e.setActive(true);
            repo.save(e);
        }
    }
}
