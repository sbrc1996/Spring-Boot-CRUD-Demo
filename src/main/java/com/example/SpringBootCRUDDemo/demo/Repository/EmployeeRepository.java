package com.example.SpringBootCRUDDemo.demo.Repository;

import com.example.SpringBootCRUDDemo.demo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
