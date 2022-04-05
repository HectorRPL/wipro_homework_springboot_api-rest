package org.hector.services;

import java.util.List;

import org.hector.entity.Employee;

public interface IEmployeeService {

    public List<Employee> findAll();

    public void save(Employee cliente);

    public Employee findById(Long id);

    public void delete(Employee cliente);

}
