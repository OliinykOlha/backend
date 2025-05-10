package de.ait.tasksapi.Repository;

import de.ait.tasksapi.Model.Task;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TasksDb implements TaskRepository {
    private static HashMap<Long, Task> tasksMap = new HashMap<>();

    static {
        tasksMap.put(1L, new Task(1L, "Провести анализ производительности сервера", 1));
        tasksMap.put(2L, new Task(2L, "Завершить отчёт по проекту", 1));
        tasksMap.put(3L, new Task(3L, "Написать документацию для API", 2));
        tasksMap.put(4L, new Task(4L, "Подготовить презентацию для клиента", 1));

    }

    @Override
    public List<Task> findAll() {
        return tasksMap.values().stream().toList();
    }

    @Override
    public Task findById(Long id) {
        return tasksMap.get(id);
    }

    @Override
    public Task save(Task task) {
        tasksMap.put(task.getId(), task);
        return task;
    }

    @Override
    public void deleteById(Long id) {
        if (!tasksMap.containsKey(id)) {
            throw new NoSuchElementException("Задача с таким id не найдена");
        }
        tasksMap.remove(id);

    }

}
