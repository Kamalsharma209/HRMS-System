package com.example.hrms.controller;

import com.example.hrms.module.Employee;
import com.example.hrms.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/onboard")
    public String onboard() {
        return "onboard";
    }

    @PostMapping("/save")
    public String save(Employee e) {
        e.setActive(true);
        service.save(e);
        return "redirect:/home";
    }

    @GetMapping("/search")
    public String searchPage(Model model) {
        model.addAttribute("emp", null);
        return "search";
    }

    @PostMapping("/find")
    public String find(@RequestParam String empCode, Model model) {
        Employee emp = service.findByCode(empCode);
        model.addAttribute("emp", emp);
        model.addAttribute("searched", true);
        return "search";
    }

    @PostMapping("/uploadPhoto")
    public String upload(@RequestParam String empCode,
                         @RequestParam MultipartFile file) throws Exception {

        Employee e = service.findByCode(empCode);

        String fileName = empCode + ".jpg";
        Path path = Paths.get("uploads/" + fileName);

        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());

        e.setPhotoPath(fileName);
        service.save(e);

        return "redirect:/home";
    }

    @GetMapping("/deactivate/{code}")
    public String deactivate(@PathVariable String code) {
        service.deactivate(code);
        return "redirect:/home";
    }

    @GetMapping("/document")
    public String documentPage() {
        return "document";
    }

    @PostMapping("/uploadDocument")
    public String uploadDocument(@RequestParam String empCode,
                                 @RequestParam MultipartFile file) throws Exception {

        Employee e = service.findByCode(empCode);

        String fileName = empCode + "_doc_" + file.getOriginalFilename();
        Path path = Paths.get("uploads/docs/" + fileName);

        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());

        e.setDocumentPath(fileName);
        service.save(e);

        return "redirect:/home";
    }

    @GetMapping("/modify")
    public String modifyPage() {
        return "modify";
    }

    @PostMapping("/modify")
    public String modify(Employee e) {

        Employee old = service.findByCode(e.getEmpCode());

        if (old != null) {
            old.setName(e.getName());
            old.setEmpRef(e.getEmpRef());
            service.save(old);
        }

        return "redirect:/home";
    }

    @GetMapping("/active")
    public String active(Model model) {
        model.addAttribute("list", service.getActive());
        return "active";
    }

    @GetMapping("/deactive")
    public String deactive(Model model) {
        model.addAttribute("list", service.getInactive());
        return "deactive";
    }

    @GetMapping("/activate/{code}")
    public String activate(@PathVariable String code) {
        service.activate(code);
        return "redirect:/active";
    }
}
