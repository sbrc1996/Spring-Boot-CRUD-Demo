package com.example.SpringBootCRUDDemo.demo.Controller;

import com.example.SpringBootCRUDDemo.demo.Entity.Employee;
import com.example.SpringBootCRUDDemo.demo.Service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    //build Employee REST API.
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //build Get All Employee REST API
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    //build Get Employee by Id REST API
    @GetMapping(value = "{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id")  long id){
        return new ResponseEntity<Employee>(employeeService.getEmployeebyId(id),HttpStatus.OK);
    }

    //build Update Employee by Id REST API
    @PutMapping("update")
    public ResponseEntity<Employee> updateEmployeeById(@RequestParam("id") long id, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployeeById(employee,id),HttpStatus.OK);
    }

    //build Delete Employee by Id REST API
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteEmployeeById(@RequestParam("id") long id){
        //delete from DB
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee Deleted Successfully..",HttpStatus.OK);
    }


}
