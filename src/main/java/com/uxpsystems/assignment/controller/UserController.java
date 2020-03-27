package com.uxpsystems.assignment.controller;

import com.uxpsystems.assignment.dao.entity.User;
import com.uxpsystems.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value="/user", method=RequestMethod.POST, consumes = "application/json")
    public Long addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value="/user", method=RequestMethod.PUT, consumes = "application/json")
    public Long updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value="/user", method=RequestMethod.DELETE, consumes = "application/json")
    public Long deleteUser(@RequestBody Long id) {
        return userService.deleteUser(id);
    }
}
