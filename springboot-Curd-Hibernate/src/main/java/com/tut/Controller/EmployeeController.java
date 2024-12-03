package com.tut.Controller;

import com.tut.entity.Employee;
import com.tut.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService empService;
    public EmployeeController(EmployeeService empService) {
        super();
        this.empService = empService;
    }
    @PostMapping
    public ResponseEntity<Employee>saveEmployee(@RequestBody Employee emp){
        return new ResponseEntity<>(empService.saveEmployee(emp), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(empService.getAllEmployees(), HttpStatus.ACCEPTED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable ("id") Long employeeId){
        return new ResponseEntity<>(empService.getEmployeeById(employeeId), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable("id")  Long empId, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(empService.updateEmployee(employee, empId), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable("id") Long id){
       empService.deleteEmployee(id);
       return  new ResponseEntity<String>("Employee deleted successfully...", HttpStatus.OK);
    }
}
