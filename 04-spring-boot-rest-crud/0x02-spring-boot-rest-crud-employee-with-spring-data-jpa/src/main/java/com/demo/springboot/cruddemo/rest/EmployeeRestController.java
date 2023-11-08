package com.demo.springboot.cruddemo.rest;

import com.demo.springboot.cruddemo.entity.Employee;
import com.demo.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
         Employee theEmployee = employeeService.findById(employeeId);

         if (theEmployee == null) {
             throw new RuntimeException("Employee with id: " + employeeId + " not found");
         }
         return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        employee.setId(0);

        Employee theEmployee = employeeService.save(employee);

        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        Employee theEmployee = employeeService.save(employee);

        return theEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee with id: " + employeeId + " not found");
        }
        employeeService.deleteById(employeeId);

        return "Deleted Employee with id: " + employeeId;
    }
}
