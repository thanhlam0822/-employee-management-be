package com.example.managementemployeebe.repository;

import com.example.managementemployeebe.dto.DepartmentDTO;
import com.example.managementemployeebe.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
@Transactional
public interface DepartmentRepository extends JpaRepository<Department,Integer> , JpaSpecificationExecutor<Department> {

 Page<Department> getDepartmentByNameContaining(String name, Pageable pageable);
 List<Department> getDepartmentByResponsibilityContaining(String name);
}
