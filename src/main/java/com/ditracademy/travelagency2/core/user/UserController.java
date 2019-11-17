package com.ditracademy.travelagency2.core.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
/*
    @Autowired
    UserRepository userRepository;
 *///wallet zeyda 5ater
    @Autowired
    UserServices userServices;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user){
      return userServices.createUser(user);
    }

    @GetMapping("/user")
    public List<User> getUser(){
        return userServices.getUser();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getOneUser(@PathVariable int id){
      return userServices.getOneUser(id);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable int id) {
        return userServices.deleteUserById(id);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable int id,@RequestBody User updatedUser){
       return userServices.updateUserById(id,updatedUser);
    }

    @GetMapping("/users")
    public  ResponseEntity<?> getUsersByAge(){
        return userServices.getUsersByAge();
    }


}
