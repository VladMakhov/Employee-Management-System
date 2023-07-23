package com.example.student.service;

import com.example.student.entity.Employee;
import com.example.student.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee student) {
        return employeeRepository.save(student);
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).get();
    }

    public Employee updateEmployee(Employee student) {
        return employeeRepository.save(student);
    }

    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

}
