package com.ijse.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.bookStore.dto.MessageResponseDTO;
import com.ijse.bookStore.dto.UserLoginDto;
import com.ijse.bookStore.dto.JwtResponseDto;
import com.ijse.bookStore.entity.User;
import com.ijse.bookStore.repository.UserRepo;
import com.ijse.bookStore.security.jwt.JwtUtils;

@CrossOrigin(origins = "*")
@RestController
public class AuthController {
    
    @Autowired
    UserRepo userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {

        if(userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponseDTO("Email is already in use"));
        }

        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPhone(user.getPhone());
        newUser.setRole(user.getRole());

        userRepository.save(newUser);
        return ResponseEntity.ok(new MessageResponseDTO("User Created Successfully"));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User user = userRepository.findByEmail(loginDto.getEmail()).orElse(null);

        return ResponseEntity.ok(new JwtResponseDto(jwt,user.getId(),user.getEmail(),user.getFirstName(),user.getLastName(),user.getPhone()));
    }

}
