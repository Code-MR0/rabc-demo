package com.mhw.rabc.controller;


import com.mhw.rabc.dto.Result;
import com.mhw.rabc.entity.User;
import com.mhw.rabc.entity.UserOrganization;
import com.mhw.rabc.service.UserOrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @className: UserOrganizationController
 * @description: UserOrganizationController
 * @author: mhw
 * @date: 2022-03-30
 * @version: 1.0
 **/
@Api(tags = "UserOrganizationController")
@RestController
@RequestMapping("/userOrganization")
@SuppressWarnings("rawtypes")
public class UserOrganizationController {
    UserOrganizationService userOrganizationService;

    public UserOrganizationController(UserOrganizationService userOrganizationService) {
        this.userOrganizationService = userOrganizationService;
    }

    /**
     * 新增
     *
     * @param userOrganization 用户组织关联信息
     */
    @ApiOperation(value = "新增")
    @PostMapping("/saveOne")
    public Result saveOne(@RequestBody UserOrganization userOrganization) {
        boolean flag = userOrganizationService.save(userOrganization);
        return Result.check(flag);
    }

    /**
     * 批量新增
     *
     * @param userOrganizationList 用户组织关联信息
     */
    @ApiOperation(value = "批量新增")
    @PostMapping("/save")
    public Result save(@RequestBody List<UserOrganization> userOrganizationList) {
        boolean flag =  userOrganizationService.saveBatch(userOrganizationList);
        return Result.check(flag);
    }

    /**
     * 更新
     *
     * @param userOrganization 用户组织关联信息
     */
    @ApiOperation(value = "更新")
    @PostMapping("/updateById")
    public Result updateById(@RequestBody UserOrganization userOrganization) {
        boolean flag = userOrganizationService.updateById(userOrganization);
        return Result.check(flag);
    }
}

