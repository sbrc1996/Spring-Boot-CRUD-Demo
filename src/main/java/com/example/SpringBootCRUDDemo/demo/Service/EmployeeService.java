package com.example.SpringBootCRUDDemo.demo.Service;

import com.example.SpringBootCRUDDemo.demo.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeebyId(long id);
    Employee updateEmployeeById(Employee employee, long id);
    void deleteEmployee(long id);
}
