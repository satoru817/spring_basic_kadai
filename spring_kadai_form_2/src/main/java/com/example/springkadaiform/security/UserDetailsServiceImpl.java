package com.example.springkadaiform.security;

import com.example.springkadaiform.entity.User;
import com.example.springkadaiform.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            System.out.println("Username received: " + username);
            User user = userRepository.findByUserName(username).get(0);
            String role = user.getRole().getName();
            Collection<GrantedAuthority>   authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(role));

            return new UserDetailsImpl(user,authorities);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
