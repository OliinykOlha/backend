package de.ait.tasksapi.Controller;

import de.ait.tasksapi.Model.Task;
import de.ait.tasksapi.Repository.TaskRepository;
import de.ait.tasksapi.Repository.TasksDb;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TasksController {
    TaskRepository taskRepository = new TasksDb();

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable(name = "id") Long id) {
        return taskRepository.findById(id);
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable(name = "id") Long id) {
        taskRepository.deleteById(id);
    }


}
