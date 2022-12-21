package com.example.managementemployeebe.restcontroller;

import com.example.managementemployeebe.dto.DepartmentDTO;
import com.example.managementemployeebe.entity.Department;
import com.example.managementemployeebe.service.DepartmentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @GetMapping("department")
    public Page<DepartmentDTO> getAll(@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
                                      @RequestParam(value = "pageSize",defaultValue = "3",required = false) Integer pageSize) {
        return departmentService.getAll(pageNumber,pageSize);
    }
    @GetMapping("department/{id}")
    public Department getById(@PathVariable Integer id) {
        return  departmentService.getById(id);
    }
    @GetMapping("department/search")
    public List<DepartmentDTO> filterByName(@RequestParam String name,
                                            @RequestParam(defaultValue = "0",required = false) Integer pageNumber,
                                            @RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize)
    {
        return departmentService.filterByName(name,pageNumber,pageSize);
    }
    @PostMapping("department")
    public Department add(@RequestBody Department department) {
        departmentService.add(department);
        return department;
    }

    @PutMapping("department/{id}")
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
