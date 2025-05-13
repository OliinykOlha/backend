package de.ait.tasksapi.service;

import de.ait.tasksapi.dto.TaskRequestDto;
import de.ait.tasksapi.dto.TaskResponseDto;

public interface TaskService {
    TaskResponseDto addTask(TaskRequestDto dto);
}
