package com.example.student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH

    })
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employeeId;

    public String getDescription() {
        return description;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public int getId() {
        return id;
    }
}
