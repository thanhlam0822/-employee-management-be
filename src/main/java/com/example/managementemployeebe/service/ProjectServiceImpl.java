package com.example.managementemployeebe.service;

import com.example.managementemployeebe.entity.Employee;
import com.example.managementemployeebe.entity.Project;
import com.example.managementemployeebe.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService  {
    @Autowired
    ProjectRepository projectRepository;
    @Override
    public List<Project> getAll() {
        return projectRepository.findAll() ;
    }

    @Override
    public Project getById(Integer id) {
        Optional<Project> project = projectRepository.findById(id);
        Project projectNeed = project.get();
        return projectNeed;
    }

    @Override
    public void add(Project project) {
       projectRepository.save(project);

    }

    @Override
    public void deleteById(Integer id) {
        projectRepository.deleteById(id);
    }
}
