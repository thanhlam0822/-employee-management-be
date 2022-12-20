package com.example.managementemployeebe.restcontroller;

import com.example.managementemployeebe.entity.Employee;
import com.example.managementemployeebe.entity.EmployeeInProject;
import com.example.managementemployeebe.entity.Project;
import com.example.managementemployeebe.service.EmployeeInProjectService;
import com.example.managementemployeebe.service.EmployeeService;
import com.example.managementemployeebe.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ProjectService projectService;
    @Autowired
    EmployeeInProjectService employeeInProjectService;
    @GetMapping("project")
    public List<Project> getAll() {
        return projectService.getAll();
    }
    @GetMapping("project/{id}")
    public Project getById(@PathVariable Integer id) {
        return projectService.getById(id);
    }
    @PostMapping("project")
    public Project add(@RequestBody Project project) {
        projectService.add(project);
        return project;
    }
    @PutMapping ("project/{id}")
    public Project editById(@PathVariable Integer id,@RequestBody Project project) {
        project.setId(id);
        projectService.add(project);
        return project;
    }
    @PutMapping ("project/{poId}/{emId}")
    public EmployeeInProject addEmployee(@PathVariable Integer poId,@PathVariable Integer emId,  EmployeeInProject employeeInProject) {
        Project project = projectService.getById(poId);
        Employee employee = employeeService.getById(emId);
        employeeInProject.setEmployee(employee);
        employeeInProject.setProject(project);
        employeeInProjectService.add(employeeInProject);
        return employeeInProject;
    }
    @DeleteMapping("project/{id}")
    public String deleteById(@PathVariable Integer id) {
        projectService.deleteById(id);
        return "Delete successfull!!!!";
    }
}
