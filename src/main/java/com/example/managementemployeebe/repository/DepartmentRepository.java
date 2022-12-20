package com.example.managementemployeebe.repository;

import com.example.managementemployeebe.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}
