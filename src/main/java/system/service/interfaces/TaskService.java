package system.service.interfaces;

import system.entity.Task;

import java.util.List;

public interface TaskService {

    void saveTask(Task task);

    List<Task> getTasksById(int id);

    void deleteTaskById(int id);

}
