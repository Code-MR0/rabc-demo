package com.mhw.rabc.controller;

import com.mhw.rabc.dto.Result;
import com.mhw.rabc.entity.Permission;
import com.mhw.rabc.entity.Role;
import com.mhw.rabc.entity.User;
import com.mhw.rabc.security.TokenManager;
import com.mhw.rabc.service.PermissionService;
import com.mhw.rabc.service.RoleService;
import com.mhw.rabc.service.UserService;
import com.mhw.rabc.util.TreeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: IndexController
 * @description: IndexController
 * @author: mhw
 * @date: 2022/3/1
 * @version: 1.0
 **/
@Api(tags = "IndexController")
@RestController
@RequestMapping("/admin/index")
@SuppressWarnings("rawtypes")
public class IndexController {


    TokenManager tokenManager;
    PermissionService permissionService;
    UserService userService;
    RoleService roleService;

    @Autowired
    public IndexController(TokenManager tokenManager, PermissionService permissionService, UserService userService, RoleService roleService) {
        this.tokenManager = tokenManager;
        this.permissionService = permissionService;
        this.userService = userService;
        this.roleService = roleService;
    }


    /**
     * 用户信息
     */
    @ApiOperation(value = "用户信息")
    @GetMapping("/info")
    public Result info(String token) {
        String info = tokenManager.getUserInfoFromToken(token);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, Object> map = new HashMap<>(16);
        User user = userService.getUserByName(username);
        List<Role> roles = roleService.findRoleByUserId(user.getId());
        List<String> roleNameList = new ArrayList<>();
        roles.forEach(i->{
            roleNameList.add(i.getRoleCode());
        });
        List<Permission> permissionList = permissionService.getMenus(user.getId().toString());
        map.put("name", username);
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("authorities", TreeUtil.createPreTree(permissionList,0L));
        map.put("roles", roleNameList);
        map.put("id", user.getId());
        return Result.success(map);
    }
}
