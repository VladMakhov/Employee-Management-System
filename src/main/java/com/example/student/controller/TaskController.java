package com.example.student.controller;

import com.example.student.entity.Task;
import com.example.student.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TaskController {
    private final TaskService taskService;

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
    public String deleteServiceById(HttpServletRequest request, @PathVariable int id) {
        String referer = request.getHeader("Referer");
        taskService.deleteTaskById(id);
        return "redirect:" + referer;
    }

    @PostMapping("/employees/tasks")
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.saveTask(task);
        return "redirect:/employees";
    }

    @GetMapping("/employees/newTask")
    public String createNewTask(HttpServletRequest request, Model model) {
        Task task = new Task();
        String referer = request.getHeader("Referer");
        String redirect = "redirect:" + referer;
        model.addAttribute("task", task);
        model.addAttribute("referer", redirect);
        return "create_task";
    }
}
