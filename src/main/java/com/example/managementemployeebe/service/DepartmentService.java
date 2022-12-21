package com.example.managementemployeebe.service;

import com.example.managementemployeebe.dto.DepartmentDTO;
import com.example.managementemployeebe.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartmentService {
    Page<DepartmentDTO> getAll(Integer pageNo, Integer pageSize);
    Department getById(Integer id);
    void add(Department department);
    void deleteById(Integer id);
    List<DepartmentDTO> filterByName(String name,Integer pageNo, Integer pageSize);

}
