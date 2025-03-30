package com.bookStore.bookStore.controller;

import com.bookStore.bookStore.Repository.UserRepository;
import com.bookStore.bookStore.Services.UserService;
import com.bookStore.bookStore.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody UserEntity user) {
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            userService.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
