package com.example.managementemployeebe.repository;

import com.example.managementemployeebe.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<Tasks,Integer> {
}
