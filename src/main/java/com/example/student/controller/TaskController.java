package com.example.student.controller;

import com.example.student.entity.Task;
import com.example.student.service.EmployeeService;
import com.example.student.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TaskController {
    private final TaskService taskService;
    private EmployeeService employeeService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/employees/tasks/{id}")
    public String listTasks(Model model, @PathVariable Integer id) {
        model.addAttribute("tasks", taskService.getTasksById(id));
        model.addAttribute("employeeId", id);
        return "all_tasks";
    }


    @GetMapping("/employees/deleteTask/{id}")
    public String deleteServiceById(@PathVariable int id) {
        taskService.deleteTaskById(id);

        return "redirect:/employees";
    }

    @PostMapping("/employees/tasks")
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.saveTask(task);
        return "redirect:/employees/tasks";
    }

    @GetMapping("/employees/newTask")
    public String createNewTask(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "create_task";
    }
}
