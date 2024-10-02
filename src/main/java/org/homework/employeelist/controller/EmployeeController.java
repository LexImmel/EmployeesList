package org.homework.employeelist.controller;

import org.homework.employeelist.Employee;
import org.homework.employeelist.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam String name,
            @RequestParam String surname
    ) {
        return employeeService.addEmployee(name, surname);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname
    ) {
        return employeeService.removeEmployee(name, surname);
    }

    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam String name,
            @RequestParam String surname
    ) {
        return employeeService.findEmployee(name, surname);
    }


    @GetMapping

    public Collection<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();
    }
}

