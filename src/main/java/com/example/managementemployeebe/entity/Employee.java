package com.example.managementemployeebe.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="employee")
public class Employee  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String role;
    @Column
    private String status;
    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthDay;
    @ManyToOne
    private Department department;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    List<EmployeeInProject> employeeInProjects;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    List<Tasks> tasks;
}
