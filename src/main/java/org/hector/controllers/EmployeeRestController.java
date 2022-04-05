package org.hector.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.hector.entity.Employee;
import org.hector.services.IEmployeeService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> index() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee show(@PathVariable Long id) {
        return this.employeeService.findById(id);
    }

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee) {
        employee.setCreateAt(new Date());
        this.employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee update(@RequestBody Employee employee, @PathVariable Long id) {
        Employee currentEmployee = this.employeeService.findById(id);
        currentEmployee.setFirstName(employee.getFirstName());
        currentEmployee.setLastName(employee.getLastName());
        currentEmployee.setEmail(employee.getEmail());
        this.employeeService.save(currentEmployee);
        return currentEmployee;
    }

    @DeleteMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        Employee currentEmployee = this.employeeService.findById(id);
        this.employeeService.delete(currentEmployee);
    }
}
