package de.ait.tasksapi.service;

import de.ait.tasksapi.dto.ProgrammerRequestDto;
import de.ait.tasksapi.dto.ProgrammerResponseDto;

import java.util.List;

public interface ProgrammerService {
    List<ProgrammerResponseDto> getAll();
    ProgrammerResponseDto addProgrammer(ProgrammerRequestDto dto);

}
