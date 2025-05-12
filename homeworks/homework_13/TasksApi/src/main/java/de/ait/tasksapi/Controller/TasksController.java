package de.ait.tasksapi.Controller;

import de.ait.tasksapi.Model.Task;
import de.ait.tasksapi.Repository.TaskRepository;
import de.ait.tasksapi.Repository.TasksDb;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class TasksController {
   private TaskRepository repository;

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return repository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable("id") Long taskId) {
        return repository.findById(taskId);
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
       return repository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public Task deleteTask(@PathVariable("id") Long id) {
        return repository.delete(id);
    }


}
