package de.ait.userapi.dto;

import de.ait.userapi.model.Address;
import de.ait.userapi.model.Role;
import lombok.*;

import java.util.HashSet;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private Address address;
    private HashSet<Role> roles;
}
