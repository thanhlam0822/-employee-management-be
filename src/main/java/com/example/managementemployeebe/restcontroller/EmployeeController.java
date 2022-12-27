package com.example.managementemployeebe.restcontroller;

import com.example.managementemployeebe.entity.Department;
import com.example.managementemployeebe.entity.Employee;
import com.example.managementemployeebe.service.DepartmentService;
import com.example.managementemployeebe.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @GetMapping("employee")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
    @GetMapping("employee/{id}")
    public Employee getById(@PathVariable Integer id) {
        return employeeService.getById(id);
    }
    @PostMapping("department/{departmentId}/employee")
    public Employee add(@PathVariable int departmentId,@RequestBody Employee employee) {
        Department department = departmentService.getById(departmentId);
        employee.setDepartment(department);
        employeeService.add(employee);
        return employee;
    }
    @PutMapping("employee/{id}")
    public Employee editById(@PathVariable Integer id,@RequestBody Employee employee) {
        employee.setId(id);
        employeeService.add(employee);
        return employee;
    }
    @PutMapping("employee/{emId}/{deId}")
    public Employee setDepartment(@PathVariable(name = "emId") Integer emId,@PathVariable(name = "deId") Integer deId) {
        Employee employee = employeeService.getById(emId);
        Department department = departmentService.getById(deId);
        employee.setDepartment(department);
        departmentService.add(department);
        return employee;

    }
    @DeleteMapping("employee/{id}")
    public String deleteById(@PathVariable Integer id) {
        Employee employee = employeeService.getById(id);
        if(employee == null) {
            return "Not found!!!";
        }
        else{
            employeeService.deleteById(id);
        }
        return "Delete successful!!";

    }
}
