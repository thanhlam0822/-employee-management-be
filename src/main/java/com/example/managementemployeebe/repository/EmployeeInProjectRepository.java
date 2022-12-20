package com.example.managementemployeebe.repository;

import com.example.managementemployeebe.entity.EmployeeInProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeInProjectRepository extends JpaRepository<EmployeeInProject,Integer> {
}
