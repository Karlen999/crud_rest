package com.bdg.crud.controller;


import com.bdg.crud.model.User;
import com.bdg.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController

@RequestMapping("/users")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public User getById(@PathVariable int id){

        return userService.getUser(id);
    }

    @PostMapping
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping(path = "/{id}")
    public void updateUserById(@RequestBody User user, @PathVariable int id){
        userService.updateUser(user, id);
    }

    @DeleteMapping(path = "/{id}")
    public User deleteById(@PathVariable int id){
        return userService.deleteById(id);
    }
}
