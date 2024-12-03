package com.tut.service;

import com.tut.entity.Employee;
import com.tut.exception.ResourceNotFoundException;
import com.tut.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl  implements  EmployeeService{

    private EmployeeRepo empRepo;
    public EmployeeServiceImpl(EmployeeRepo empRepo) {
        this.empRepo = empRepo;
    }
    @Override
    public Employee saveEmployee(Employee employee) {
        return empRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }
    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = empRepo.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee existEmp = empRepo.findById( id).orElseThrow(() ->  new ResourceNotFoundException("Employee", "Id", id));
        existEmp.setFirstName(employee.getFirstName());
        existEmp.setLastName(employee.getLastName());
        existEmp.setEmail(employee.getEmail());
        empRepo.save(existEmp);
        return existEmp;
    }

    @Override
    public void deleteEmployee(Long id) {
        Optional<Employee>employee = Optional.ofNullable(empRepo.findById(id).orElseThrow(() ->
                                                                                                          new ResourceNotFoundException("Employee", "Id", id)));
        empRepo.deleteById(id);
    }
}
