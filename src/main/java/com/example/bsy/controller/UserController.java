package com.example.bsy.controller;

import com.example.bsy.dto.RegisterRequestDto;
import com.example.bsy.entity.User;
import com.example.bsy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public ResponseEntity<User> signUp(@RequestBody RegisterRequestDto registerRequestDto){
        User user = userService.register(registerRequestDto);
        return ResponseEntity.ok(user);
    }


}
