package com.Thymeleaf.thymeleaf.service;

import com.Thymeleaf.thymeleaf.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private User user;
    public UserPrincipal(User theUser) {
        this.user=theUser;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      /* if(null!=user.getRole() && !user.getRole().isEmpty()){
            return Arrays.stream(user.getRole().split(","))
                    .map(role->new SimpleGrantedAuthority(("ROLE_"+role))).collect(Collectors.toList());
        }
        return new ArrayList<>();*/
       String role = user.getRole();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
