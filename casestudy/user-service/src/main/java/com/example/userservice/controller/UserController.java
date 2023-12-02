package com.example.userservice.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	private UserService userService;

	@PostMapping("/add")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
		UserDto savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable int id){
		UserDto user = userService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto> updateUser(@Valid @PathVariable int id,
												 @RequestBody UserDto user){
		user.setId(id);
		UserDto updatedUser  = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		userService.deleteUser(id);
		return new ResponseEntity<>("User Deleted Successfully",HttpStatus.OK);
	}
	
}
