package com.ijse.bookStore.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ijse.bookStore.entity.User;
import com.ijse.bookStore.repository.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    private UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        User user = userRepository.findByEmail(email)
            .orElseThrow(()-> new UsernameNotFoundException("User not found with given email"+email));

        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().name());

        return org.springframework.security.core.userdetails.User.builder()
            .username(user.getEmail())
            .password(user.getPassword())
            .authorities(Collections.singletonList(authority))
            .build();
    }


}
