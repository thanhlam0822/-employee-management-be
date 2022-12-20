package com.example.managementemployeebe.service;

import com.example.managementemployeebe.entity.EmployeeInProject;
import com.example.managementemployeebe.repository.EmployeeInProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeInProjectServiceImpl implements EmployeeInProjectService {
    @Autowired
    EmployeeInProjectRepository employeeInProjectRepository;
    @Override
    public void add(EmployeeInProject employeeInProject) {
        employeeInProjectRepository.save(employeeInProject);
    }
}
