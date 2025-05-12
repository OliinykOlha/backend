package de.ait.tasksapi.Repository;

import de.ait.tasksapi.Model.Task;

import java.util.List;

public interface TaskRepository {
     List<Task> findAll();
     Task findById(Long id);
     Task save(Task task);
     Task delete(Long id);
}
