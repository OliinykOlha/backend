package de.ait.tasksapi.Controller;


import de.ait.tasksapi.Model.Programmer;
import de.ait.tasksapi.Model.Task;
import de.ait.tasksapi.Repository.ProgrammerDb;
import de.ait.tasksapi.Repository.ProgrammerRepository;
import de.ait.tasksapi.dto.ProgrammerRequestDto;
import de.ait.tasksapi.dto.ProgrammerResponseDto;
import de.ait.tasksapi.service.ProgrammerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@AllArgsConstructor
@RestController
@RequiredArgsConstructor
public class ProgrammerController {
    private final ProgrammerRepository repository;
    private final ProgrammerService service;

//    public ProgrammerController(ProgrammerRepository repository) {
//        this.repository = repository;
//    }

    @GetMapping("/programmers")
    public List<ProgrammerResponseDto> getProgrammers() {
        return service.getAll();
    }

    @GetMapping("/programmers/{id}")
    public Programmer getProgrammerById(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

    @GetMapping("/programmers/{id}/tasks")
   public List<Task> getListOfTasks(@PathVariable("id")  Long id) {
       return repository.findTasksByProgrammerId(id);
   }


   @PutMapping("/programmers")
   public ProgrammerResponseDto createProgrammer(@RequestBody ProgrammerRequestDto dto) {
        return service.addProgrammer(dto);
   }

   @PutMapping("/programmers/{programmerId}/tasks/{taskId}")
   public void addTaskToProgrammer (@PathVariable("programmerId") Long programmerId, @PathVariable("taskId") Long taskId) {
        repository.addTaskToProgrammer(programmerId, taskId);
   }
}
