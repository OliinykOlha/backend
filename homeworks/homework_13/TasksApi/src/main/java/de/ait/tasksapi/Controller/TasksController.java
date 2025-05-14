package de.ait.tasksapi.Controller;

import de.ait.tasksapi.Model.Task;
import de.ait.tasksapi.Repository.TaskRepository;
import de.ait.tasksapi.Repository.TasksDb;
import de.ait.tasksapi.dto.TaskRequestDto;
import de.ait.tasksapi.dto.TaskResponseDto;
import de.ait.tasksapi.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@RestController

public class TasksController {
   private TaskRepository repository;
   private final TaskService service;
   private Scanner scanner;

    @Autowired
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }


    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return repository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable("id") Long taskId) {
        return repository.findById(taskId);
    }

    @PostMapping("/tasks")
    public TaskResponseDto addTask(@RequestBody TaskRequestDto dto) {
       return service.addTask(dto);
    }

    @DeleteMapping("/tasks/{id}")
    public Task deleteTask(@PathVariable("id") Long id) {
        return repository.delete(id);
    }


}
