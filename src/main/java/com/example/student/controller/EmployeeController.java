package com.example.student.controller;

import com.example.student.entity.Employee;
import com.example.student.entity.Task;
import com.example.student.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.employeeService = service;
    }

    @GetMapping("/employees")
    public String listEmployee(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployee());
        return "employees";
    }

    @GetMapping("/employees/new")
    public String createEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee";
    }

    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee Employee) {
        employeeService.saveEmployee(Employee);
        return "redirect:/employees";
    }

    @GetMapping("employees/edit/{id}")
    public String editEmployeeForm(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "edit_employee";
    }

    @PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable int id, @ModelAttribute("employee") Employee employee) {
        Employee existingEmployee = employeeService.getEmployeeById(id);
        existingEmployee.setId(id);
        existingEmployee.setName(employee.getName());
        existingEmployee.setSurname(employee.getSurname());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setTitle(employee.getTitle());
        existingEmployee.setSalary(employee.getSalary());

        employeeService.updateEmployee(existingEmployee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }

    @GetMapping("/employees/task/{id}")
    public String addTaskToEmployee(@PathVariable int id) {
        return "all_tasks";
    }

    @GetMapping("/employees/newTask")
    public String createNewTask(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "create_task";
    }

}