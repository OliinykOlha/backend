package de.ait.userapi.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class User {
    @Setter
    private Long id;
    private String name;
    private String email;
    private String password;


}
