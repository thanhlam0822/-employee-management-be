package com.example.managementemployeebe.service;

import com.example.managementemployeebe.entity.Department;
import com.example.managementemployeebe.entity.Employee;
import com.example.managementemployeebe.repository.DepartmentRepository;
import com.example.managementemployeebe.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee employeeNeed = employee.get();
        return employeeNeed;

    }

    @Override
    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);

    }
}
