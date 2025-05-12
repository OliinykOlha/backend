package de.ait.tasksapi.Repository;

import de.ait.tasksapi.Model.Programmer;
import de.ait.tasksapi.Model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProgrammerRepository {
    List<Programmer> findAll();
    Programmer findById(Long id);
    Programmer save(Programmer programmer);
    List<Task> findTasksByProgrammerId(Long id);
    void addTaskToProgrammer(Long programmerId, Long taskId);
    void deleteTaskFromProgrammer(Long programmerId, Long taskId);

}
