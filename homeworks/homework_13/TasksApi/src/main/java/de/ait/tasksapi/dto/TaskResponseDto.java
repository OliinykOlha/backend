package de.ait.tasksapi.dto;

import de.ait.tasksapi.Model.Priority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TaskResponseDto {
    private Long id;
    private String description;
    private Priority priority;
}
