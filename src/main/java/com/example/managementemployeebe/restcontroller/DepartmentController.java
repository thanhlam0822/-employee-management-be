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
    public List<DepartmentDTO> getAll() {
        return departmentService.getAll();
    }
    @GetMapping("department/{id}")
    public Department getById(@PathVariable Integer id) {
        return  departmentService.getById(id);
    }
    @GetMapping("department/search")
    public List<DepartmentDTO> filterByName(@RequestParam String name,
                                            @RequestParam(defaultValue = "0",required = false) Integer pageNumber,
                                            @RequestParam(value = "pageSize",defaultValue = "10",required = false) Integer pageSize)
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
    public List<DepartmentDTO> deleteById(@PathVariable Integer id,
                                          @RequestParam String name,
                                          @RequestParam(defaultValue = "0",required = false) Integer pageNumber,
                                          @RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize ) {

        departmentService.deleteById(id);
        return departmentService.filterByName("",pageNumber,pageSize);

    }
    @GetMapping("/department/test")
    public List<Department> findByManyField(@RequestParam(required = false) String query1 , @RequestParam(required = false) String query2) {
        return departmentService.filterByManyField(query1,query2);
    }
}
