package com.example.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import com.example.springbootdeveloper.dto.AddUserRequest;
import com.example.springbootdeveloper.repository.UserRepository;
import com.example.springbootdeveloper.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Long save(AddUserRequest dto){
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }

    public User findById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("Unexpected User"));
    }
}
