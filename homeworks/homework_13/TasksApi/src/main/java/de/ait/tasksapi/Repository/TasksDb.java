package de.ait.tasksapi.Repository;

import de.ait.tasksapi.Model.Priority;
import de.ait.tasksapi.Model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Repository
public class TasksDb implements TaskRepository {
    private static HashMap<Long, Task> tasksMap = new HashMap<>();
    private static Long lastId = 5L;

    static {
        tasksMap.put(1L, new Task(1L, "Провести анализ производительности сервера", Priority.HIGH));
        tasksMap.put(2L, new Task(2L, "Завершить отчёт по проекту", Priority.MEDIUM));
        tasksMap.put(3L, new Task(3L, "Написать документацию для API", Priority.LOW));
        tasksMap.put(4L, new Task(4L, "Подготовить презентацию для клиента", Priority.HIGH));

    }


    @Override
    public List<Task> findAll() {
        return tasksMap.values().stream().toList();
    }

    @Override
    public Task findById(Long id) {
        if(id < 1 || id > lastId) {
            throw new RuntimeException("id not found");
        }
        return tasksMap.get(id);
    }

    @Override
    public Task save(Task task) {
       task.setId(lastId++);
       tasksMap.put(lastId, task);
       return task;
    }

    @Override
    public Task delete(Long id) {
        Task task = tasksMap.remove(id);
        return task;
    }


}


