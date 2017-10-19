package com.sergeeva.simpleSpringSecurityApp.service;

import com.sergeeva.simpleSpringSecurityApp.domain.Users;
import com.sergeeva.simpleSpringSecurityApp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @PostConstruct
    public void init(){
        usersRepository.findByName("admin").ifPresent(users -> {
            users.setPassword(new BCryptPasswordEncoder().encode("admin"));
            usersRepository.save(users);
        });
    }

    public Users findByUsername(String username) {
        return usersRepository.findByName(username).orElseThrow(()->new UsernameNotFoundException("Username not found"));
    }
}
