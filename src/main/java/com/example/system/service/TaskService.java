package com.example.system.service;

import com.example.system.entity.Task;
import com.example.system.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

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
