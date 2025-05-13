package de.ait.tasksapi.service;

import de.ait.tasksapi.dto.ProgrammerRequestDto;
import de.ait.tasksapi.dto.ProgrammerResponseDto;

public interface ProgrammerService {
    ProgrammerResponseDto addProgrammer(ProgrammerRequestDto dto);
}
