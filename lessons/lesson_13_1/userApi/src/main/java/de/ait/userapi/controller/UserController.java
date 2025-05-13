package de.ait.userapi.controller;

import de.ait.userapi.dto.UserRequestDto;
import de.ait.userapi.dto.UserResponseDto;
import de.ait.userapi.model.User;
import de.ait.userapi.repository.UserDb;
import de.ait.userapi.repository.UserRepository;
import de.ait.userapi.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/users")
    public List<UserResponseDto> getUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserResponseDto getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PostMapping("/users")
    public UserResponseDto addUser(@RequestBody UserRequestDto dto) {
        return service.addUser(dto);
    }

}
