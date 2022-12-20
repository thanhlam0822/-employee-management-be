package com.example.managementemployeebe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EmployeeInProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name="employee_id")
    Employee employee;
    @ManyToOne
    @JoinColumn(name = "project_id")
    Project project;

}
