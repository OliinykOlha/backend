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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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
    public ResponseEntity<List<ProgrammerResponseDto>> getProgrammers() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/programmers/{id}")
    public ResponseEntity<Programmer> getProgrammerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(repository.findById(id));

    }

    @GetMapping("/programmers/{id}/tasks")
    public List<Task> getListOfTasks(@PathVariable("id") Long id) {
        return repository.findTasksByProgrammerId(id);
    }


    @PutMapping("/programmers")
    public ResponseEntity<ProgrammerResponseDto> createProgrammer(@RequestBody ProgrammerRequestDto dto) {
        ProgrammerResponseDto saved = service.addProgrammer(dto);
        try {
            return ResponseEntity.created(new URI("http:localhost/programmers/" + saved.getId())).body(saved);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/programmers/{programmerId}/tasks/{taskId}")
    public ResponseEntity<Void> addTaskToProgrammer(@PathVariable("programmerId") Long programmerId, @PathVariable("taskId") Long taskId) {
        try {
            repository.addTaskToProgrammer(programmerId, taskId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Internal Server Error
        }
    }
}
