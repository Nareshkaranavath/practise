package com.tut.service;

import com.tut.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee , Long Id );
  public void  deleteEmployee(Long id);
}
