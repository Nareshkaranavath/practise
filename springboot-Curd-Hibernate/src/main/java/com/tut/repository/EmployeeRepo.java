package com.tut.repository;

import com.tut.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface  EmployeeRepo  extends JpaRepository<Employee, Long> {
}
