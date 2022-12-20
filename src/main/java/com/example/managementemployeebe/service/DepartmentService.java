package com.example.managementemployeebe.service;

import com.example.managementemployeebe.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAll();
    Department getById(Integer id);
    void add(Department department);
    void deleteById(Integer id);

}
