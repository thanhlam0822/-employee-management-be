package com.example.managementemployeebe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "task")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(length = 2000)
    private String description;
    @Column
    private String status;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Project project;
}
