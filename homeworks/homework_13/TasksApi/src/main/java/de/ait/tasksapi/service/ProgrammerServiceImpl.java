package de.ait.tasksapi.service;

import de.ait.tasksapi.Model.Programmer;
import de.ait.tasksapi.Repository.ProgrammerRepository;
import de.ait.tasksapi.dto.ProgrammerRequestDto;
import de.ait.tasksapi.dto.ProgrammerResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgrammerServiceImpl implements ProgrammerService{
   private final ProgrammerRepository repository;

    @Override
    public ProgrammerResponseDto addProgrammer(ProgrammerRequestDto dto) {
        Programmer programmer = new Programmer(null, dto.getName());
        Programmer saved = repository.save(programmer);
        if(saved != null) {
            return new ProgrammerResponseDto(saved.getId(), saved.getName());
        } else {
            throw new RuntimeException("Programmer wasn't saved");
        }
    }
}
