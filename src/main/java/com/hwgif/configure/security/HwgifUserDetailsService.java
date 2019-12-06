package com.hwgif.configure.security;

import com.hwgif.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lc.huang
 * @description
 * @date 2019/11/26
 */
@Service
public class HwgifUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    /**
     25      * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，因为资源是不变的，而用户的角色是会变的
     26      */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         com.hwgif.demo.bean.User sysUser = userService.find(1);
         if (null == sysUser) {
                 throw new UsernameNotFoundException(username);
             }
         List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//         for (
//                 role : sysUser.getRoleList()) {
//                 for (SysPermission permission : role.getPermissionList()) {
//                         authorities.add(new SimpleGrantedAuthority(permission.getCode()));
//                     }
//             }

         return new User(sysUser.getName(), sysUser.getPassword(), authorities);
    }
}
