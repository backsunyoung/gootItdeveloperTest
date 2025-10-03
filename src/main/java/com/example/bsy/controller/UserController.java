package com.example.bsy.controller;

import com.example.bsy.dto.RegisterRequestDto;
import com.example.bsy.entity.User;
import com.example.bsy.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @Operation(summary = "회원가입")
    public ResponseEntity<User> signUp(@RequestBody RegisterRequestDto registerRequestDto){
        User user = userService.register(registerRequestDto);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/find")
    @Operation(summary = "전 회원 조회")
    public List<User> finaAllUsers(){
        return userService.findAllUsers();
    }


}
