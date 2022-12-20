package com.example.managementemployeebe.restcontroller;

import com.example.managementemployeebe.entity.Employee;
import com.example.managementemployeebe.entity.Project;
import com.example.managementemployeebe.entity.Tasks;
import com.example.managementemployeebe.service.EmployeeService;
import com.example.managementemployeebe.service.ProjectService;
import com.example.managementemployeebe.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TasksController {
    @Autowired
    TasksService tasksService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ProjectService projectService;
    @GetMapping("tasks")
    public List<Tasks> getAll() {
        return tasksService.getAll();
    }
    @GetMapping("tasks/{id}")
    public Tasks getById(@PathVariable Integer id) {
        return tasksService.getById(id);
    }
    @PostMapping("tasks/{poId}/{emId}")
    public Tasks add(@PathVariable Integer poId, @PathVariable Integer emId,@RequestBody Tasks tasks) {
        Project project = projectService.getById(poId);
        Employee employee = employeeService.getById(emId);
        tasks.setProject(project);
        tasks.setEmployee(employee);
        tasksService.add(tasks);
        return tasks;
    }
    @PutMapping("tasks/{id}")
    public Tasks edit(@PathVariable Integer id,@RequestBody Tasks tasks) {
        tasks.setId(id);
        tasksService.add(tasks);
        return tasks;
    }
    @DeleteMapping("tasks/{id}")
    public String deleteById(@PathVariable Integer id) {
        tasksService.deleteById(id);
        return "Deleted";
    }
}
