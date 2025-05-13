package de.ait.tasksapi.service;

import de.ait.tasksapi.Model.Task;
import de.ait.tasksapi.Repository.TaskRepository;
import de.ait.tasksapi.dto.TaskRequestDto;
import de.ait.tasksapi.dto.TaskResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{
    private final TaskRepository repository;

    @Override
    public TaskResponseDto addTask(TaskRequestDto dto) {
        Task task = new Task(null, dto.getDescription(), dto.getPriority());
        Task saved = repository.save(task);
        if(saved != null) {
            return taskResponseDto(saved);
        } else {
            throw new RuntimeException("Error");
        }
    }

    public static TaskResponseDto taskResponseDto(Task task) {
        return new TaskResponseDto(task.getId(), task.getDescription(), task.getPriority());
    }
}
