package de.ait.userapi.controller;

import de.ait.userapi.dto.UserRequestDto;
import de.ait.userapi.dto.UserResponseDto;
import de.ait.userapi.exceptions.BadRoleException;
import de.ait.userapi.exceptions.UserNotFoundException;
import de.ait.userapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/users")
    public List<UserResponseDto> getUsers(@RequestParam(name = "role", required = false) String role) {
        if(role == null || role.isBlank()) {
            return service.getAllUsers();
        } else {
            return service.getUsersByRole(role);
        }

    }

    @GetMapping("/users/{id}")
    public UserResponseDto getUser(@PathVariable(name="id") Long id) {
        return service.getUserById(id);
    }

    @PostMapping("users/{id}/roles")
    public ResponseEntity<UserResponseDto> assignRole(@PathVariable Long id, @RequestParam(name="role") String role) {
        try {
            UserResponseDto userResponseDto = service.assignRole(id, role);
            return ResponseEntity.ok(userResponseDto);
        } catch (UserNotFoundException e){
            return ResponseEntity.notFound().build();
        } catch (BadRoleException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/users")
    public UserResponseDto addUser(@RequestBody UserRequestDto dto){
        return service.addUser(dto);
    }


}
