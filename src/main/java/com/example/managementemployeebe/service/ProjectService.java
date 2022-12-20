package com.example.managementemployeebe.service;

import com.example.managementemployeebe.entity.Department;
import com.example.managementemployeebe.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();
    Project getById(Integer id);
    void add(Project project);
    void deleteById(Integer id);
}
