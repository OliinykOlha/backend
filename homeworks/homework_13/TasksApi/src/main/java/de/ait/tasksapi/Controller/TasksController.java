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
   private final TaskService service;

   
    @GetMapping("/tasks")
    public List<TaskResponseDto> getTasks() {
        return service.addAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public TaskResponseDto getTaskById(@PathVariable("id") Long taskId) {
        return service.findTaskById(taskId);
    }

    @PostMapping("/tasks")
    public TaskResponseDto addTask(@RequestBody TaskRequestDto dto) {
        return service.addTask(dto);
    }

    @DeleteMapping("/tasks/{id}")
    public TaskResponseDto deleteTask(@PathVariable("id") Long id) {
        return service.deleteTask(id);
    }


}
