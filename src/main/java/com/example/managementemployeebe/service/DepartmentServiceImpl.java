package com.example.managementemployeebe.service;

import com.example.managementemployeebe.dto.DepartmentDTO;
import com.example.managementemployeebe.entity.Department;
import com.example.managementemployeebe.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public Page<DepartmentDTO> getAll(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Department> departmentsPage = departmentRepository.findAll(pageable);
        List<Department> departmentList = departmentsPage.getContent();
        List<DepartmentDTO> departmentDTOS = departmentList.stream().map((department) -> modelMapper.map(department,DepartmentDTO.class))
                .collect(Collectors.toList());
        Page<DepartmentDTO> departmentDTOPage = new PageImpl<>(departmentDTOS);
        return departmentDTOPage;

    }

    @Override
    public Department getById(Integer id) {
        Optional<Department> department = departmentRepository.findById(id);
        Department departmentNeed = department.get();
        return departmentNeed;

    }

    @Override
    public void add(Department department) {
         departmentRepository.save(department);
    }

    @Override
    public void deleteById(Integer id) {
        departmentRepository.deleteById(id);

    }

    @Override
    public List<DepartmentDTO> filterByName(String name,Integer pageNo, Integer pageSize) {
       Pageable pageable = PageRequest.of(pageNo,pageSize);
       Page<Department> departmentPage = departmentRepository.getDepartmentByNameContaining(name,pageable);
       List<Department> departmentList = departmentPage.getContent();
       List<DepartmentDTO> departmentDTOS = departmentList.stream().map((department) -> modelMapper.map(department,DepartmentDTO.class))
                .collect(Collectors.toList());

        return departmentDTOS;
    }


}
