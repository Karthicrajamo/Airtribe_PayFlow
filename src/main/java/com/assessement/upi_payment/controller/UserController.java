package com.assessement.upi_payment.controller;

import com.assessement.upi_payment.entity.Users;
import com.assessement.upi_payment.exception.UserNotFoundException;
import com.assessement.upi_payment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Users registerUser(@RequestBody Users user){
        Users registerUser = userService.registerUser(user);
        return registerUser;
    }

    @GetMapping
    public List<Users> getUsers(@RequestParam(required = false) Long id) throws UserNotFoundException {
        if(id == null){
            return userService.getAllUsers();
        }
        return Collections.singletonList(userService.getUserById(id));
    }

    @GetMapping("/upi/{upiId}")
    public Users geUserByUpiId(@PathVariable String upiId){
        return userService.findByUpiId(upiId);
    }



    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleUserNotFoundException(UserNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message",ex.getMessage()));
    }
}
