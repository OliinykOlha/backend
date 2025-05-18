package de.ait.userapi.dto;

import de.ait.userapi.model.Address;
import lombok.*;

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
}
