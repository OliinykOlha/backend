package de.ait.tasksapi.mappers;

import de.ait.tasksapi.Model.Task;
import de.ait.tasksapi.dto.TaskResponseDto;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")

public interface TaskMapper {
    TaskResponseDto toResponseDto(Task task);
    List<TaskResponseDto> toResponseDtoList(List<Task> task);
}
