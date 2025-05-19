package de.ait.tasksapi.mappers;

import de.ait.tasksapi.Model.Programmer;
import de.ait.tasksapi.dto.ProgrammerRequestDto;
import de.ait.tasksapi.dto.ProgrammerResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgrammerMapper {
    ProgrammerResponseDto toDto(Programmer programmer);
    List<ProgrammerResponseDto> toDtoList(List<Programmer> programmer);
    Programmer toEntity(ProgrammerRequestDto dto);
}
