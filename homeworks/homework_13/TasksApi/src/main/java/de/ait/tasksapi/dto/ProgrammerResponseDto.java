package de.ait.tasksapi.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProgrammerResponseDto {
    private Long id;
    private String name;
    private Set<TaskResponseDto> tasks;
}
