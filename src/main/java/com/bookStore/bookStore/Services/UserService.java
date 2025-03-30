package com.bookStore.bookStore.Services;

import com.bookStore.bookStore.Repository.UserRepository;
import com.bookStore.bookStore.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseEntity<?> signup(UserEntity user){
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }

    }
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public void updateUser(UserEntity user) {
        userRepository.save(user);
    }
}
