package com.example.student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String department;
    private String title;
    private int salary;

    @OneToMany(mappedBy = "employeeId", cascade = CascadeType.ALL)
    private List<Task> taskList;

    public Employee(String name, String surname, String department, String title, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.title = title;
        this.salary = salary;
    }
}
