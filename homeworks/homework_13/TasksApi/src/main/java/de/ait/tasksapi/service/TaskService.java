package de.ait.tasksapi.service;

import de.ait.tasksapi.dto.TaskRequestDto;
import de.ait.tasksapi.dto.TaskResponseDto;


import java.util.List;


public interface TaskService {
    List<TaskResponseDto> findAllTasks();
    TaskResponseDto findTaskById(Long id);
    TaskResponseDto addTask(TaskRequestDto dto);
    TaskResponseDto deleteTask(Long id);
}
