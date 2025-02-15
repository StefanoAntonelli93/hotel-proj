package com.example.hotel_proj.controller;

import com.example.hotel_proj.entity.User;
import com.example.hotel_proj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService service;

    public UserController(@Autowired UserService service) {
        this.service = service;
    }
    @GetMapping("/users/create")
        public User createUser(@RequestParam String username, @RequestParam String password, @RequestParam String email){
            return service.createUser(username, password, email);
        }
    @GetMapping("/users")
        public List<User> getAllUsers(){
        return service.getAllUsers();
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> user = service.getUserId(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)) // use map for Optional
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/users/username")
    public ResponseEntity<User> getUserName(@PathVariable String username){
        Optional<User> user = service.getUserName(username);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/users")
    public ResponseEntity<User> addRoom(@RequestBody User user) {
        service.addUser(user);
        return (user != null) ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        service.updateUser(user);
        return (user != null) ? new ResponseEntity<>(user, HttpStatus.ACCEPTED)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long id) {
        boolean deleted = service.deleteUser(id);
        if (deleted) {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

}
