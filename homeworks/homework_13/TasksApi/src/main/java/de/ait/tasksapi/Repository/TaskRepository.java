package de.ait.tasksapi.Repository;

import de.ait.tasksapi.Model.Task;

import java.util.List;

public interface TaskRepository {
    public List<Task> findAll();
    public Task findById(Long id);
    public Task save(Task task);
    public void deleteById(Long id);
}
