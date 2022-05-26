package com.Thymeleaf.thymeleaf.service;

import com.Thymeleaf.thymeleaf.DAO.UserRepository;
import com.Thymeleaf.thymeleaf.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User theUser = userRepository.findByEmail(username);
        if (theUser == null) {
            throw new UsernameNotFoundException("User not found "+username);
        }

        //return new org.springframework.security.core.userdetails.User(theUser.getEmail(),theUser.getPassword())
        return new UserPrincipal(theUser);
    }
}