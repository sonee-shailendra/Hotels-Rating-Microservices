package com.ssonee.user.service.rest;


import com.ssonee.user.service.entities.User;
import com.ssonee.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    int retryCount=1;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User usr = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(usr);
    }

    @GetMapping("/{userId}")
    //@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    @Retry(name = "ratingServiceRetry", fallbackMethod="ratingHotelFallback")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        logger.info("get Single user details");
        logger.info("Retry Count :"+ retryCount);
        retryCount++;
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    //ratingHotelFallback
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
        logger.info("Fallback method executed as service is down "+ex.getMessage());
        User user = User.builder().email("dummy@gmail.com")
                .name("dummy").
                about("This is dummy user due to service failure")
                .userId("1234").build();
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public  ResponseEntity<List<User>> getAllUsers(){
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }
}
