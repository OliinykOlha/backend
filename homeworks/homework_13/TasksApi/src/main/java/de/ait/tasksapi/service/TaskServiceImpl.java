package de.ait.tasksapi.service;

import de.ait.tasksapi.Model.Task;
import de.ait.tasksapi.Repository.TaskRepository;
import de.ait.tasksapi.dto.TaskRequestDto;
import de.ait.tasksapi.dto.TaskResponseDto;
import de.ait.tasksapi.mappers.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{
    private final TaskRepository repository;
    private final TaskMapper mapper;

//    @Override
//    public List<TaskResponseDto> findAllTasks() {
//        List<Task> taskList = repository.findAll();
//       return taskList.stream().map(TaskServiceImpl::toTaskResponseDto).toList();
//    }

//    @Override
//    public List<TaskResponseDto> findAllTasks() {
//        List<Task> taskList = repository.findAll();
//        return taskList.stream().map(t->mapper.toResponseDto(t)).toList();
//    }

    @Override
    public List<TaskResponseDto> findAllTasks() {
        return mapper.toResponseDtoList(repository.findAll());
    }

    @Override
    public TaskResponseDto findTaskById(Long id) {
        Task task = repository.findById(id);
        if (task != null) {
            return toTaskResponseDto(task);
        } else {
            throw new RuntimeException("Task with id" + id + " not found");
        }
    }

    @Override
    public TaskResponseDto addTask(TaskRequestDto dto) {
        Task task = new Task(null, dto.getDescription(), dto.getPriority());
        Task saved = repository.save(task);
        if(saved != null) {
            return toTaskResponseDto(saved);
        } else {
            throw new RuntimeException("Error");
        }
    }

    @Override
    public TaskResponseDto deleteTask(Long id) {
       Task task = repository.delete(id);
       if(task.getId() != null) {
           return toTaskResponseDto(task);
       } else {
           throw new RuntimeException("Id " + id + " not exist");
       }
    }

    public static TaskResponseDto toTaskResponseDto(Task task) {
        return new TaskResponseDto(task.getId(), task.getDescription(), task.getPriority());
    }
}
