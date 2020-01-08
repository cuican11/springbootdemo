package com.hwgif.configure.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

//public class UserEntity extends User {
//
//    private String phone;
//
//
//    public UserEntity(String username, String password, Collection<? extends GrantedAuthority> authorities){
//        super(username, password, authorities);
//    }
//
//
//    public UserEntity(String username, String password, String phone ,Collection<? extends GrantedAuthority> authorities){
//        super(username, password, authorities);
//        this.phone = phone;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//}
public class UserEntity implements UserDetails {

    private String username;

    private String password;

    private String phone;

    private final Set<SimpleGrantedAuthority> authorities;

    private final boolean accountNonExpired;

    private final boolean accountNonLocked;

    private final boolean credentialsNonExpired;

    private final boolean enabled;

    public UserEntity(String username, String password, String phone, Set<SimpleGrantedAuthority> authorities) {
        this(username, password, phone,authorities, true, true,true, true);
    }

    public UserEntity(String username, String password, String phone, Set<SimpleGrantedAuthority> authorities, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.authorities = authorities;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }


    public String getPhone() {
        return this.phone;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return this.authorities;
    }

    @Override
    public String getPassword(){
        return this.password;
    }

    @Override
    public String getUsername(){
        return this.username;
    }
    @Override
    public boolean isAccountNonExpired(){
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked(){
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled(){
        return this.enabled;
    }
}