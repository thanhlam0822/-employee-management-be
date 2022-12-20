package com.example.managementemployeebe.restcontroller;

import com.example.managementemployeebe.entity.Department;
import com.example.managementemployeebe.service.DepartmentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @GetMapping("department")
    public List<Department> getAll() {
        return departmentService.getAll();
    }
    @GetMapping("department/{id}")
    public Department getById(@PathVariable Integer id) {
        return  departmentService.getById(id);
    }
    @PostMapping("department")
    public Department add(@RequestBody Department department) {
        departmentService.add(department);
        return department;
    }

    @PatchMapping("department/{id}")
    public Department editById(@PathVariable Integer id,@RequestBody Department department ) {
        department.setId(id);

         departmentService.add(department);
         return department;
    }
    @DeleteMapping("department/{id}")
    public String deleteById(@PathVariable Integer id ) {
        Department department = departmentService.getById(id);
        if(department == null) {
            return "Not found!!!";
        }
        else{
            departmentService.deleteById(id);
        }
        return "Delete successful!!";

    }


}
