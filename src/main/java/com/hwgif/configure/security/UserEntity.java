package com.hwgif.configure.security;

import com.hwgif.demo.bean.SysRole;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@Data
public class UserEntity implements UserDetails {

    private String username;

    private String password;

    private String phone;

    private final Set<SimpleGrantedAuthority> authorities;

    private final boolean accountNonExpired;

    private final boolean accountNonLocked;

    private final boolean credentialsNonExpired;

    private final boolean enabled;

    private List<SysRole> roles;

    public UserEntity() {
        this("", "", "",null, true, true,true, true);

    }

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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        //
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