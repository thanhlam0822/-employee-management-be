package com.example.managementemployeebe.service;

import com.example.managementemployeebe.entity.Department;
import com.example.managementemployeebe.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getById(Integer id);
    void add(Employee employee);
    void deleteById(Integer id);
}
