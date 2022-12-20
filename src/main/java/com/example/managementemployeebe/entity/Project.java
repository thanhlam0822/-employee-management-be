package com.example.managementemployeebe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String status;
    @OneToMany(mappedBy = "project")
    @JsonIgnore
    List<EmployeeInProject> employeeInProjects;
    @JsonIgnore
    @OneToMany(mappedBy = "project")
    List<Tasks> tasks;
}
