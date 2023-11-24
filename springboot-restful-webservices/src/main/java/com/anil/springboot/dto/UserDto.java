package com.anil.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty(message = "user first name cannot be empty")
    private String firstName;
    @NotEmpty(message = "user last name cannot be empty")
    private String lastName;
    @NotEmpty(message = "user Email cannot be empty")
    @Email(message = "Email address should be Valid")
    private String email;
}
