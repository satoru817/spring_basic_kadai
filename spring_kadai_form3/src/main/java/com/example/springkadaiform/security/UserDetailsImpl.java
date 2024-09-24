package com.example.springkadaiform.security;

import com.example.springkadaiform.entity.User;
import com.example.springkadaiform.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {
    private final User user;
    private final Collection<GrantedAuthority> authorities;//UserDetailsImplがインスタンス化した後にこれらの属性は変化しないでほしい。

    public UserDetailsImpl(User user, Collection<GrantedAuthority> authorities){
        this.user = user;
        this.authorities = authorities;
    }

    @Override
    public String getPassword(){
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public Collection<?extends GrantedAuthority> getAuthorities(){
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }
}
