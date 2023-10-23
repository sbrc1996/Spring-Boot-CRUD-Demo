package com.example.SpringBootCRUDDemo.demo.Service.Impl;

import com.example.SpringBootCRUDDemo.demo.Entity.Employee;
import com.example.SpringBootCRUDDemo.demo.Exception.ResourceNotFoundException;
import com.example.SpringBootCRUDDemo.demo.Repository.EmployeeRepository;
import com.example.SpringBootCRUDDemo.demo.Service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    //here we use Constructor based dependency injection.
    private EmployeeRepository employeeRepository;

    private EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeebyId(long id) {
        //check if the employee is present in DB or not..
        Optional<Employee>  employee = employeeRepository.findById(id);
        if(employee.isPresent())
            return employee.get();
        else
            throw new ResourceNotFoundException("Employee","Id",id);
    }

    @Override
    public Employee updateEmployeeById(Employee employee, long id) {
        //check if the employee is present in DB or not..
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if(existingEmployee.isPresent()){
            existingEmployee.get().setFirstName(employee.getFirstName());
            existingEmployee.get().setLastName(employee.getLastName());
            existingEmployee.get().setEmail(employee.getEmail());
            employeeRepository.save(existingEmployee.get());
            return existingEmployee.get();
        }
        else{
            throw new ResourceNotFoundException("Employee","Id",id);
        }
    }

    @Override
    public void deleteEmployee(long id) {
        //check if the employee is present in DB or not..
        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        if(existingEmployee.isPresent())
            employeeRepository.deleteById(id);
        else
            throw new ResourceNotFoundException("Employee","id",id);
    }
}
