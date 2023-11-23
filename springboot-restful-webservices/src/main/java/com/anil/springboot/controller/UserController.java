package com.anil.springboot.controller;

import com.anil.springboot.entity.User;
import com.anil.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User saveUser = userService.createUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    /**
     * Get User REST API
     * http://localhost:8080/api/user/1
     * @param userId
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Get All Users REST API
     * http://localhost:8080/api/user/users
     * @return
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * Update User REST API
     * http://localhost:8080/api/user/1
     * @param userId
     * @param user
     * @return
     */
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody User user) {
       user.setId(userId);
       User updatedUser = userService.updateUser(user);
       return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /**
     * Delete User REST API
     * http://localhost:8080/api/user/4
     * @param userId
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted Succeccsfully: {}",HttpStatus.OK);
    }

}
