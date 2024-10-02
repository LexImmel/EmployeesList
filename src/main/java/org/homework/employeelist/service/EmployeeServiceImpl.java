package org.homework.employeelist.service;

import org.homework.employeelist.Employee;
import org.homework.employeelist.exceptions.EmployeeAlreadyAddedException;
import org.homework.employeelist.exceptions.EmployeeNotFoundException;
import org.homework.employeelist.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public int employeeLimit = 5;
    private List<Employee> employees = new ArrayList<>(List.of(
            new Employee("John", "Smith"),
            new Employee("Alex", "Vincera"),
            new Employee("Geralt", "Rivia"),
            new Employee("David", "Hasselhoff")

    ));


    @Override
    public Employee addEmployee(String name, String surname) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(name, surname);


        if (employees.size() == employeeLimit) {
            throw new EmployeeStorageIsFullException("EmployeeStorageIsFull");
        }

        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
        }

        employees.add(employee);
        return employee;

    }


    @Override

    public Employee removeEmployee(String name, String surname) throws EmployeeNotFoundException {
        Employee employee = new Employee(name, surname);

        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
        employees.remove(employee);

        return employee;
    }

    @Override
    public Employee findEmployee(String name, String surname) throws EmployeeNotFoundException {
        Employee employeeFind = new Employee(name, surname);

        if (!employees.contains(employeeFind)) {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
        for (Employee employee : employees) {
            if (employee.equals(employeeFind)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;

    }
}