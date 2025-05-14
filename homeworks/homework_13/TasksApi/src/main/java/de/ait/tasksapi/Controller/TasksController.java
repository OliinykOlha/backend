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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@RestController

public class TasksController {
   private final TaskService service;

   
    @GetMapping("/tasks")
    public ResponseEntity <List<TaskResponseDto>> getTasks() {
//        return ResponseEntity.ok(service.findAllTasks());
        List<TaskResponseDto> allTasks = service.findAllTasks();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Task-Size", String.valueOf(allTasks.size()));
        return new ResponseEntity<>(allTasks, headers, HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity <TaskResponseDto> getTaskById(@PathVariable("id") Long taskId) {
        try {
            return ResponseEntity.ok(service.findTaskById(taskId));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/tasks")
    public  TaskResponseDto addTask(@RequestBody TaskRequestDto dto) {
        return service.addTask(dto);
    }

    @DeleteMapping("/tasks/{id}")
    public TaskResponseDto deleteTask(@PathVariable("id") Long id) {
        return service.deleteTask(id);
    }


}
