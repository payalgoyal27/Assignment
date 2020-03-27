package com.uxpsystems.assignment.controller;

import com.uxpsystems.assignment.dao.entity.User;
import com.uxpsystems.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public ResponseEntity getUsers() {
        return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value="/user", method=RequestMethod.POST, consumes = "application/json")
    public ResponseEntity addUser(@RequestBody User user) {
        return new ResponseEntity(userService.addUser(user),HttpStatus.OK);
    }

    @RequestMapping(value="/user", method=RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity updateUser(@RequestBody User user) {
        return new ResponseEntity(userService.updateUser(user),HttpStatus.OK);
    }

    @RequestMapping(value="/user", method=RequestMethod.DELETE, consumes = "application/json")
    public ResponseEntity deleteUser(@RequestBody Long id) {
        return new ResponseEntity(userService.deleteUser(id),HttpStatus.OK);
    }
}
