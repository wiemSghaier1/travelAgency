package com.ditracademy.travelagency2.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    public void createUser(@RequestBody User user){
        userRepository.save(user);
    }

    @GetMapping("/user")
    public List<User> getUser(){
        return userRepository.findAll();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable int id)
    {
        userRepository.deleteById(id);
    }

    @PutMapping("/user/{id}")
    public void updateUserById(@PathVariable int id,@RequestBody String name, @RequestBody int age){

    userRepository.getOne(id).setAge(age);
    userRepository.getOne(id).setName(name);
    }
}
