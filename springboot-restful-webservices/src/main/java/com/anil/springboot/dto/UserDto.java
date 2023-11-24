package com.anil.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDto Model Information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    @Schema(
            description = "User First Name"
    )
    @NotEmpty(message = "user first name cannot be empty")
    private String firstName;
    @Schema(
            description = "User Last Name"
    )
    @NotEmpty(message = "user last name cannot be empty")
    private String lastName;
    @Schema(
            description = "User Email Address"
    )
    @NotEmpty (message = "user Email cannot be empty")
    @Email (message = "Email address should be Valid")
    private String email;
}
