package com.ssonee.user.service.rest;


import com.ssonee.user.service.entities.User;
import com.ssonee.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User usr = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(usr);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public  ResponseEntity<List<User>> getAllUsers(){
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }
}
