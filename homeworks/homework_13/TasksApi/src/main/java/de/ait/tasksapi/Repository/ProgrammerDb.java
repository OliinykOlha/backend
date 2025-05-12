package de.ait.tasksapi.Repository;

import de.ait.tasksapi.Model.Programmer;
import de.ait.tasksapi.Model.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class ProgrammerDb implements ProgrammerRepository {
    private TaskRepository taskRepository;
    private static Long lastID = 3L;
    private static HashMap<Long, Programmer> map = new HashMap<>();
     {
        map.put(1L, new Programmer(1L, "Jack"));
        map.put(2L, new Programmer(2L, "Nick"));
        map.put(3L, new Programmer(3L, "John"));
       addTaskToProgrammer(1L, 1L);
       addTaskToProgrammer(1L, 2L);
       addTaskToProgrammer(2L, 3L);
    }

    @Override
    public List<Programmer> findAll() {
        return map.values().stream().toList();
    }

    @Override
    public Programmer findById(Long id) {
         Programmer programmer = map.get(id);
         if(programmer == null) {
             throw new RuntimeException("Programmer with id " + id + " not found");
         } else {
             return programmer;
         }

    }

    @Override
    public Programmer save(Programmer programmer) {
         programmer.setId(lastID++);
         map.put(lastID, programmer);
        return programmer;
    }

    @Override
    public List<Task> findTasksByProgrammerId(Long id) {
        return new ArrayList<>(findById(id).getTasks());
    }

    @Override
    public void addTaskToProgrammer(Long programmerId, Long taskId) {
        try {
            Task task = taskRepository.findById(taskId);
            Programmer programmer = map.get(programmerId);
            if(programmer != null) {
                programmer.addTask(task);
            } else {
                throw new RuntimeException("Programmer not found");
            }
        } catch (Exception e) {
         throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTaskFromProgrammer(Long programmerId, Long taskId) {
    Programmer programmer = findById(programmerId);
    Task task = taskRepository.findById(taskId);
    programmer.removeTask(task);


    }


}
