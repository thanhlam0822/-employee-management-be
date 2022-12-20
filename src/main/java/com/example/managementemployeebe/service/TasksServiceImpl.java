package com.example.managementemployeebe.service;

import com.example.managementemployeebe.entity.Tasks;
import com.example.managementemployeebe.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TasksServiceImpl implements TasksService {
    @Autowired
    TasksRepository tasksRepository;
    @Override
    public List<Tasks> getAll() {
        return tasksRepository.findAll();
    }

    @Override
    public Tasks getById(Integer id) {
        Optional<Tasks> tasks = tasksRepository.findById(id);
        Tasks tasksNeed = tasks.get();
        return tasksNeed;
    }

    @Override
    public void add(Tasks tasks) {
        tasksRepository.save(tasks);
    }

    @Override
    public void deleteById(Integer id) {
        tasksRepository.deleteById(id);
    }
}
