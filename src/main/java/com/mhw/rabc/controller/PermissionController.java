package com.mhw.rabc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mhw.rabc.dto.Result;
import com.mhw.rabc.entity.Permission;
import com.mhw.rabc.service.PermissionService;
import com.mhw.rabc.util.TreeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @className: PermissionController
 * @description: PermissionController
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
@Slf4j
@Api(tags = "PermissionController")
@RestController
@RequestMapping("/permission")
@SuppressWarnings("rawtypes")
public class PermissionController {

    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }


    /**
     * 分页列表
     *
     * @param permission 分页信息
     */
    @ApiOperation(value = "分页列表")
    @GetMapping("/pageList")
    public Result pageList(Permission permission) {
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>(permission);
        Page<Permission> page = new Page<>(permission.getPage(), permission.getLimit());
        Page<Permission> pageList = permissionService.page(page, queryWrapper);
        return Result.success(pageList);
    }

    /**
     * list列表
     *
     * @param permission 查询条件
     */
    @ApiOperation(value = "list列表")
    @GetMapping("/list")
    public Result list(Permission permission) {
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>(permission);
        List<Permission> permissionList = permissionService.list(queryWrapper);
        List<Permission> tree = TreeUtil.createPreTree(permissionList, 0L);
        return Result.success(tree);
    }

    /**
     * 根据主键查询
     *
     * @param id 主键id
     */
    @ApiOperation(value = "根据主键查询")
    @GetMapping("/info/getById")
    public Result info(@RequestParam("id") Long id) {
        Permission permission = permissionService.getById(id);
        return Result.success(permission);
    }

    /**
     * 新增
     *
     * @param permission 权限信息
     */
    @ApiOperation(value = "新增")
    @PostMapping("/saveOne")
    public Result saveOne(@RequestBody Permission permission) {
        boolean flag = permissionService.save(permission);
        return Result.check(flag);
    }

    /**
     * 批量新增
     *
     * @param permissionList 权限信息
     */
    @ApiOperation(value = "批量新增")
    @PostMapping("/save")
    public Result save(@RequestBody List<Permission> permissionList) {
        boolean flag = permissionService.saveBatch(permissionList);
        return Result.check(flag);
    }

    /**
     * 更新
     *
     * @param permission 权限信息
     */
    @ApiOperation(value = "更新")
    @PostMapping("/updateById")
    public Result updateById(@RequestBody Permission permission) {
        boolean flag = permissionService.updateById(permission);
        return Result.check(flag);
    }

    /**
     * 批量更新
     *
     * @param permissionList 权限信息
     */
    @ApiOperation(value = "批量更新")
    @PostMapping("/update")
    public Result update(@RequestBody List<Permission> permissionList) {
        boolean flag = permissionService.updateBatchById(permissionList);
        return Result.check(flag);
    }

    /**
     * 删除
     *
     * @param permission 权限信息
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/removeById")
    public Result removeById(@RequestBody Permission permission) {
        // todo 删除下级权限并解除角色和权限的关联关系
        boolean flag = permissionService.removeById(permission);
        return Result.check(flag);
    }

    /**
     * 批量删除
     *
     * @param permissionList 权限信息
     */
    @ApiOperation(value = "批量删除")
    @DeleteMapping("/remove")
    public Result remove(@RequestBody List<Permission> permissionList) {
        boolean flag = permissionService.removeByIds(permissionList);
        return Result.check(flag);
    }

    /**
     * 根据用户ID获取Menus
     *
     * @param userId userId
     */
    @ApiOperation(value = "根据用户ID获取Menus")
    @GetMapping("/{userId}/getMenus")
    public Result getMenus(@PathVariable String userId){
        return Result.success(permissionService.getMenus(userId));
    }

}

