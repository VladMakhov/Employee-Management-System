package com.example.student.service;

import com.example.student.entity.Task;
import com.example.student.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getTasksById(int id) {
        var allTasks = taskRepository.findAll();
        List<Task> result = new ArrayList<>();
        for(Task task : allTasks) {
            if (task.getEmployeeId().getId() == id) {
                result.add(task);
            }
        }
        return result;
    }

    public void deleteTaskById(int id) {
        taskRepository.deleteById(id);
    }

}
