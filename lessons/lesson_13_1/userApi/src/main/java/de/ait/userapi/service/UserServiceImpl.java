package de.ait.userapi.service;


import de.ait.userapi.dto.UserRequestDto;
import de.ait.userapi.dto.UserResponseDto;
import de.ait.userapi.mappers.UserMapper;
import de.ait.userapi.model.User;
import de.ait.userapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public List<UserResponseDto> getAllUsers() {
        return mapper.toResponseDtoList(repository.findAll());
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        Optional<User> user = repository.findById(id);
       return mapper.toResponseDto(user.orElse(null));

    }

    @Override
    public UserResponseDto addUser(UserRequestDto dto) {
       User user = mapper.fromRequestDto(dto);
      User savedUser = repository.save(user);
      return mapper.toResponseDto(savedUser);

    }


}

