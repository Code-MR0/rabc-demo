package com.mhw.rabc.service.impl;

/**
 * @className: MyUserDetailsService
 * @description: TODO
 * @author: mhw
 * @date: 2022/3/1
 * @version: 1.0
 **/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mhw.rabc.entity.User;
import com.mhw.rabc.security.entity.SecurityUser;
import com.mhw.rabc.service.PermissionService;
import com.mhw.rabc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    private PermissionService permissionService;

    @Autowired
    public MyUserDetailsServiceImpl(UserService userService, PermissionService permissionService) {
        this.userService = userService;
        this.permissionService = permissionService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询数据
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        User user = userService.getOne(wrapper);
        //判断
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        //根据用户查询用户权限列表
        List<String> permissionValueList = new ArrayList<>();
        SecurityUser securityUser = new SecurityUser();
        securityUser.setCurrentUserInfo(user);
        securityUser.setPermissionValueList(permissionValueList);
        return securityUser;
    }
}

