package com.example.userservice.dto;

import com.example.userservice.entity.UserRole;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private int id;
	@NotEmpty(message = "user name cannot be empty")
	private String name;
	@NotEmpty (message = "user Email cannot be empty")
	@Email (message = "Email address should be Valid")
	private String email;
	@NotEmpty(message = "Name cannot be Empty")
	private UserRole userRole;
}
