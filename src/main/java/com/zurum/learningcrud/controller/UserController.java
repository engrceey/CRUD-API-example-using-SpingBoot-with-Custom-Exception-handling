package com.zurum.learningcrud.controller;

import com.zurum.learningcrud.exception.ResourceNotFoundException;
import com.zurum.learningcrud.model.User;
import com.zurum.learningcrud.repository.UserRepository;
import com.zurum.learningcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9800")
@RequestMapping("/api/")
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id+" Not found in database"));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("users")
    public ResponseEntity<User> addUsers(@RequestBody User users) {
        User newUsers = userService.saveUser(users);
        return new ResponseEntity<>(newUsers, HttpStatus.OK);
    }

    @PutMapping("users")
    public ResponseEntity<User> updateUser( @RequestBody User user) {
        User userToUpdate = userService.updateUser(user);
        return new ResponseEntity<>(userToUpdate, HttpStatus.OK);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<HttpStatus> deleteUserId(@PathVariable long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("addUsers")
    public ResponseEntity<List<User>> addUsers(@RequestBody List<User> users) {
        return new ResponseEntity<>(userService.saveUsers(users), HttpStatus.OK);
    }

    @GetMapping("getAllUser")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userService.getUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }


}
