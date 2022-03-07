package com.mhw.rabc.controller;

import com.mhw.rabc.dto.Result;
import com.mhw.rabc.security.TokenManager;
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

    @Autowired
    TokenManager tokenManager;

    /**
     * 用户信息
     */
    @ApiOperation(value = "用户信息")
    @GetMapping("/info")
    public Result info() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, Object> map = new HashMap<>();
        List<String> roleNameList = new ArrayList<>();
        roleNameList.add("");
        map.put("name", username);
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("roles", roleNameList);
        // todo 获取并封装用户权限信息
        return Result.success(map);
    }
}
