package com.example.bsy.service;

import com.example.bsy.dto.RegisterRequestDto;
import com.example.bsy.entity.User;
import com.example.bsy.exception.CustomException;
import com.example.bsy.exception.ErrorType;
import com.example.bsy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(RegisterRequestDto registerRequestDto){



        if(userRepository.existsByEmail(registerRequestDto.email())){

            throw new CustomException(ErrorType.EMAIL_EXISTS);

        }

        User user = User.builder()
                .username(registerRequestDto.username())
                .email(registerRequestDto.email())
                .password(passwordEncoder.encode(registerRequestDto.password()))
                .build();

        return userRepository.save(user);



    }




}
