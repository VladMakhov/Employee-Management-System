package com.example.student.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @TableGenerator(name = "init", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "init")
    private int id;

    private String description;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employeeId;

    public Task() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }
}
