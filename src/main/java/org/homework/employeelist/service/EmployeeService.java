package org.homework.employeelist.service;

import org.homework.employeelist.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface EmployeeService {

    Employee addEmployee(String name, String surname);

    Employee removeEmployee(String name, String lastName);

    Employee findEmployee(String name, String lastName);

    List<Employee> getAllEmployees();
}
