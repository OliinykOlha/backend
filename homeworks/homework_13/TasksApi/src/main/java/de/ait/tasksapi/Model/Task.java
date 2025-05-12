package de.ait.tasksapi.Model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="id")

public class Task {
    @Setter
    private Long id;
    private String description;
    private Priority priority;

}
