package com.example.hrms.controller;

import com.example.hrms.module.Employee;
import com.example.hrms.service.EmailService;
import com.example.hrms.service.EmployeeService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    private final EmployeeService employeeService;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public RegistrationController(EmployeeService employeeService,
                                  PasswordEncoder passwordEncoder,
                                  EmailService emailService) {
        this.employeeService = employeeService;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    @GetMapping("/register")
    public String showRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String register(Employee emp){

        emp.setRole("ROLE_EMPLOYEE");  // default role
        emp.setActive(true);

        emp.setPassword(passwordEncoder.encode(emp.getPassword()));

        employeeService.save(emp);  // go through service

        emailService.sendRegistrationMail(emp.getEmail());

        return "redirect:/login";
    }

    @GetMapping("/apply-job")
    public String applyJob(){
        return "apply-job";
    }

    @GetMapping("/job-status")
    public String jobStatus(){
        return "job-status";
    }

    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }

    @GetMapping("/documents")
    public String docs(){
        return "documents";
    }

    @GetMapping("/leave")
    public String leave(){
        return "leave";
    }
}