package de.ait.tasksapi.service;

import de.ait.tasksapi.Model.Programmer;
import de.ait.tasksapi.Repository.ProgrammerRepository;
import de.ait.tasksapi.dto.ProgrammerRequestDto;
import de.ait.tasksapi.dto.ProgrammerResponseDto;
import de.ait.tasksapi.dto.TaskResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProgrammerServiceImpl implements ProgrammerService{
   private final ProgrammerRepository repository;

    @Override
    public List<ProgrammerResponseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(ProgrammerServiceImpl::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProgrammerResponseDto addProgrammer(ProgrammerRequestDto dto) {
        Programmer programmer = new Programmer(null, dto.getName());
        Programmer saved = repository.save(programmer);
        if(saved != null) {
            return toDto(saved);
        } else {
            throw new RuntimeException("Programmer wasn't saved");
        }
    }

    private static ProgrammerResponseDto toDto(Programmer programmer) {
        Set<TaskResponseDto> taskDtos = programmer.getTasks()
                .stream()
                .map(task -> new TaskResponseDto(task.getId(), task.getDescription(), task.getPriority()))
                .collect(Collectors.toSet());

        return new ProgrammerResponseDto(programmer.getId(), programmer.getName(), taskDtos);
    }
}
