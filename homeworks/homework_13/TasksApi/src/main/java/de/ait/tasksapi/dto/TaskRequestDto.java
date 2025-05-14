package de.ait.tasksapi.dto;

import de.ait.tasksapi.Model.Priority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TaskRequestDto {
    private String description;
    private Priority priority;
}
