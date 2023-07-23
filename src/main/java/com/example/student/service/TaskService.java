package com.example.student.service;

import com.example.student.entity.Employee;
import com.example.student.entity.Task;
import com.example.student.repository.EmployeeRepository;
import com.example.student.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).get();
    }

    public List<Task> getTasksById(int id) {
        List<Task> allTasks = taskRepository.findAll();
        List<Task> result = new ArrayList<>();
        for(Task task : allTasks) {
            if (task.getEmployeeId().getId() == id) {
                result.add(task);
            }
        }
        return result;
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTaskById(int id) {
        taskRepository.deleteById(id);
    }

}
