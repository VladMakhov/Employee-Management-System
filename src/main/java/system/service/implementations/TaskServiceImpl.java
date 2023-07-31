package system.service.implementations;

import system.entity.Task;
import system.repository.TaskRepository;
import system.service.interfaces.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
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

    @Override
    public void deleteTaskById(int id) {
        taskRepository.deleteById(id);
    }

}
