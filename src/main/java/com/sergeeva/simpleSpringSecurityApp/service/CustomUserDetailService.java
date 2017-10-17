package com.sergeeva.simpleSpringSecurityApp.service;

import com.sergeeva.simpleSpringSecurityApp.domain.CustomUserDetails;
import com.sergeeva.simpleSpringSecurityApp.domain.Users;
import com.sergeeva.simpleSpringSecurityApp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByName(username).orElseThrow(()->new UsernameNotFoundException("Username not found"));
        return new CustomUserDetails(user);
    }
}
