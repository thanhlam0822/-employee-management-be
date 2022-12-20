package com.example.managementemployeebe.service;

import com.example.managementemployeebe.entity.Tasks;

import java.util.List;

public interface TasksService {
    List<Tasks> getAll();
    Tasks getById(Integer id);
    void add(Tasks tasks);
    void deleteById(Integer id);

}
