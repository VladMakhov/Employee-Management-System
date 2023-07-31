package system.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;


@Getter
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDepartment() {
        return department;
    }

    public String getTitle() {
        return title;
    }

    public int getSalary() {
        return salary;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public Employee() {
    }

    public Employee(int id, String name, String surname, String department, String title, int salary, List<Task> taskList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.title = title;
        this.salary = salary;
        this.taskList = taskList;
    }
}

