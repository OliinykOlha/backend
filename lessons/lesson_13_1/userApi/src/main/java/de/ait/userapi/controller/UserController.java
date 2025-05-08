package de.ait.userapi.controller;

import de.ait.userapi.model.User;
import de.ait.userapi.repository.UserDb;
import de.ait.userapi.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    UserRepository repository = new UserDb();

    @GetMapping("/users")
    public List<User> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return repository.save(user);
    }

}
