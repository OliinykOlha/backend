package de.ait.userapi.service;

import de.ait.userapi.dto.UserRequestDto;
import de.ait.userapi.dto.UserResponseDto;
import de.ait.userapi.exceptions.BadRoleException;
import de.ait.userapi.exceptions.UserNotFoundException;
import de.ait.userapi.mappers.UserMapper;
import de.ait.userapi.model.Role;
import de.ait.userapi.model.User;
import de.ait.userapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository repository;
    private final UserMapper maper;
    private final PasswordEncoder encoder;

    @Override
    public List<UserResponseDto> getAllUsers() {
        System.out.println("Users .....");
        return maper.toResponseDtoList(repository.findAll());
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = repository.findById(id).get();
        if(user!=null){
            return maper.toResponseDto(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public UserResponseDto addUser(UserRequestDto dto) {
        User user = maper.fromRequestDto(dto);
        user.addRole(Role.USER);
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println("Pass:"  + user.getPassword());
        User savedUser = repository.save(user);
        if(savedUser!=null){
            return maper.toResponseDto(savedUser);
        } else {
            throw  new RuntimeException("Error create new user");
        }

    }

    private static Role roleOf(String strRole){
        try {
            return Role.valueOf(strRole.toUpperCase().trim());
        } catch (Exception e){
            throw new BadRoleException();
        }
    }

    @Override
    public List<UserResponseDto> getUsersByRole(String strRole) {
        System.out.println("Users by role");
        Role role = roleOf(strRole);
        return maper.toResponseDtoList(repository.findByRolesContaining(role));
    }

    @Override
    public UserResponseDto assignRole(Long userId, String strRole) {
        Role role = roleOf(strRole);
        User user = repository.findById(userId).orElseThrow(UserNotFoundException::new);
        user.addRole(role);
        repository.save(user); // ToDo
        return maper.toResponseDto(user);
    }

    @Override
    public UserResponseDto removeRole(Long userId, String strRole) {
        Role role = roleOf(strRole);
        User user = repository.findById(userId).orElseThrow(UserNotFoundException::new);
        user.removeRole(role);
        repository.save(user); // ToDo
        return maper.toResponseDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findUserByEmail(username).orElseThrow(()-> new UsernameNotFoundException("username not found"+username));
    }
}