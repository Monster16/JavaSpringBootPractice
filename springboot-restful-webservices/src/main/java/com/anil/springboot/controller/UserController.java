package com.anil.springboot.controller;

import com.anil.springboot.dto.UserDto;
import com.anil.springboot.entity.User;
import com.anil.springboot.exception.ErrorDetails;
import com.anil.springboot.exception.ResourceNotFoundException;
import com.anil.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@Tag(
        name = "CRUD REST APIs for user Resource",
        description = "CRUD REST APIs - Create, Update, Get, Get All, Delete"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    /**
     * Create User REST API
     * http://localhost:8080/api/user/create
     * @param user
     * @return
     */
    @Operation(
            summary = "Create User Rest API",
            description = "Create User Rest API is used to save user in database"
    )
    @ApiResponse(
           responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        UserDto saveUser = userService.createUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    /**
     * Get User REST API
     * http://localhost:8080/api/user/1
     * @param userId
     * @return
     */
    @Operation(
            summary = "GET User BY ID Rest API",
            description = "GET User BY ID Rest API is used to GET USER FROM database"
    )
    @ApiResponse(
            responseCode = "20O",
            description = "HTTP Status 20O SUCCESS"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Get All Users REST API
     * http://localhost:8080/api/user/users
     * @return
     */
    @Operation(
            summary = "GET ALL the User Rest API",
            description = "GET ALL the User Rest API is used to GET ALL USER FROM database"
    )
    @ApiResponse(
            responseCode = "20O",
            description = "HTTP Status 20O SUCCESS"
    )
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * Update User REST API
     * http://localhost:8080/api/user/1
     * @param userId
     * @param user
     * @return
     */
    @Operation(
            summary = "UPDATE User Rest API",
            description = "UPDATE User Rest API is used to UPDATE USER IN database"
    )
    @ApiResponse(
            responseCode = "20O",
            description = "HTTP Status 20O SUCCESS"
    )
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @PathVariable("id") Long userId,
                                           @RequestBody UserDto user) {
       user.setId(userId);
       UserDto updatedUser = userService.updateUser(user);
       return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /**
     * Delete User REST API
     * http://localhost:8080/api/user/4
     * @param userId
     * @return
     */
    @Operation(
            summary = "DELETE User Rest API",
            description = "DELETE User Rest API is used to DELETE USER FROM database"
    )
    @ApiResponse(
            responseCode = "20O",
            description = "HTTP Status 20O SUCCESS"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted Succeccsfully: {}",HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                        WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }

}
