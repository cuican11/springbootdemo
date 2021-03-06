package com.hwgif.configure.security;

import com.hwgif.demo.bean.SysPermission;
import com.hwgif.demo.bean.SysRole;
import com.hwgif.demo.bean.SysUser;
import com.hwgif.demo.service.SysUserService;
import com.hwgif.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lc.huang
 * @description
 * @date 2019/11/26
 */
@Service
public class HwgifUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;


    /**
     * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，因为资源是不变的，而用户的角色是会变的
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.getLoadUserByName(username);
        if (null == sysUser) {
            throw new UsernameNotFoundException(username);
        }

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        for (SysRole role : sysUser.getRoleList()) {
            for (SysPermission permission : role.getPermissionList()) {
                authorities.add(new SimpleGrantedAuthority(permission.getCode()));
            }
        }
        UserEntity user = new UserEntity(sysUser.getUsername(), sysUser.getPassword(), "13558483203",authorities);
        return user;
    }
}
