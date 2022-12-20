package com.example.managementemployeebe.service;

import com.example.managementemployeebe.entity.Department;
import com.example.managementemployeebe.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(Integer id) {
        Optional<Department> department = departmentRepository.findById(id);
        Department departmentNeed = department.get();
        return departmentNeed;

    }

    @Override
    public void add(Department department) {
         departmentRepository.save(department);
    }

    @Override
    public void deleteById(Integer id) {
        departmentRepository.deleteById(id);

    }


}
