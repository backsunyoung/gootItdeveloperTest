package com.example.bsy.service;

import com.example.bsy.dto.RegisterRequestDto;
import com.example.bsy.entity.User;
import com.example.bsy.exception.CustomExcepiton;
import com.example.bsy.exception.ErrorType;
import com.example.bsy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User register(RegisterRequestDto registerRequestDto){



        if(userRepository.existsByEmail(registerRequestDto.email())){

            throw new CustomExcepiton(ErrorType.EMAIL_EXISTS);

        }

        User user = User.builder()
                .username(registerRequestDto.username())
                .email(registerRequestDto.email())
                .password(registerRequestDto.password())
                .build();

        return userRepository.save(user);



    }




}
