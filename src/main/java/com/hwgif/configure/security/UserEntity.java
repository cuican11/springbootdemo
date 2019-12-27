package com.hwgif.configure.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserEntity extends User {

    private String phone;


    public UserEntity(String username, String password, Collection<? extends GrantedAuthority> authorities){
        super(username, password, authorities);
    }


    public UserEntity(String username, String password, String phone ,Collection<? extends GrantedAuthority> authorities){
        super(username, password, authorities);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
