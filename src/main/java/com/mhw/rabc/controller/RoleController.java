package com.mhw.rabc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import com.mhw.rabc.dto.Result;
import com.mhw.rabc.entity.Permission;
import com.mhw.rabc.entity.Role;
import com.mhw.rabc.entity.RolePermission;
import com.mhw.rabc.service.RolePermissionService;
import com.mhw.rabc.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: RoleController
 * @description: RoleController
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
@Slf4j
@Api(tags = "RoleController")
@RestController
@RequestMapping("/role")
@SuppressWarnings("rawtypes")
public class RoleController {
    private final RoleService roleService;
    private final RolePermissionService rolePermissionService;

    @Autowired
    public RoleController(RoleService roleService, RolePermissionService rolePermissionService) {
        this.roleService = roleService;
        this.rolePermissionService = rolePermissionService;
    }


    /**
     * 分页列表
     *
     * @param role 分页信息
     */
    @ApiOperation(value = "分页列表")
    @GetMapping("/pageList")
    public Result pageList(Role role) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        if (role.getRoleName() != null) {
            queryWrapper.like("role_name", role.getRoleName());
        }
        if (role.getRoleName() == null && role.getRoleCode() != null) {
            queryWrapper.like("role_code", role.getRoleCode());
        }
        if (role.getRoleName() != null && role.getRoleCode() != null) {
            queryWrapper.or();
            queryWrapper.like("role_code", role.getRoleCode());
        }
        Page<Role> page = new Page<>(role.getPage(), role.getLimit());
        Page<Role> pageList = roleService.page(page, queryWrapper);
        return Result.success(pageList);
    }

    /**
     * list列表
     *
     * @param role 查询条件
     */
    @ApiOperation(value = "list列表")
    @GetMapping("/list")
    public Result list(Role role) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>(role);
        List<Role> roleList = roleService.list(queryWrapper);
        return Result.success(roleList);
    }

    /**
     * 根据主键查询
     *
     * @param id 主键id
     */
    @ApiOperation(value = "根据主键查询")
    @GetMapping("/info/getById")
    public Result info(@RequestParam("id") Long id) {
        Role role = roleService.getById(id);
        return Result.success(role);
    }

    /**
     * 新增
     *
     * @param role 角色信息
     */
    @ApiOperation(value = "新增")
    @PostMapping("/saveOne")
    public Result saveOne(@RequestBody Role role) {
        boolean flag = roleService.saveOne(role);
        return Result.check(flag);
    }

    /**
     * 批量新增
     *
     * @param roleList 角色信息
     */
    @ApiOperation(value = "批量新增")
    @PostMapping("/save")
    public Result save(@RequestBody List<Role> roleList) {
        List<Role> list = roleService.saveList(roleList);
        if (list.size() == 0) {
            return Result.success();
        }
        return Result.failed("部分角色添加失败", list);
    }

    /**
     * 更新
     *
     * @param role 角色信息
     */
    @ApiOperation(value = "更新")
    @PostMapping("/updateById")
    public Result updateById(@RequestBody Role role) {
        boolean flag = roleService.updateById(role);
        return Result.check(flag);
    }

    /**
     * 批量更新
     *
     * @param roleList 角色信息
     */
    @ApiOperation(value = "批量更新")
    @PostMapping("/update")
    public Result update(@RequestBody List<Role> roleList) {
        boolean flag = roleService.updateBatchById(roleList);
        return Result.check(flag);
    }

    /**
     * 删除
     *
     * @param role 角色信息
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/removeById")
    public Result removeById(@RequestBody Role role) {
        boolean flag = roleService.removeById(role);
        return Result.check(flag);
    }

    /**
     * 批量删除
     *
     * @param roleList 角色信息
     */
    @ApiOperation(value = "批量删除")
    @DeleteMapping("/remove")
    public Result remove(@RequestBody List<Role> roleList) {
        boolean flag = roleService.removeByIds(roleList);
        return Result.check(flag);
    }

    /**
     * 更具roleId获取权限idList
     * @param id roleId
     * @return 权限idList
     */
    @ApiOperation(value = "更具roleId获取权限idList")
    @GetMapping("/permission/{id}")
    public Result getPermissionIdList(@PathVariable String id) {
        QueryWrapper<RolePermission> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",id);
        List<RolePermission> entityIds = rolePermissionService.list(wrapper);
        List<Long> list = new ArrayList<>();
        entityIds.forEach(i->{
            list.add(i.getPermissionId());
        });
        return Result.success(list);
    }

    /**
     * 角色分配权限
     *
     * @param permissionIds permissionIds
     */
    @ApiOperation(value = "批量删除")
    @PostMapping("/permission/{id}")
    @Transactional(rollbackFor=Exception.class)
    public Result remove(@RequestBody List<Long> permissionIds, @PathVariable Long id) {
        List<RolePermission> list = new ArrayList<>(permissionIds.size());
        permissionIds.forEach(i->{
            list.add(new RolePermission(id,i));
        });
        QueryWrapper<RolePermission> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",id);
        rolePermissionService.remove(wrapper);
        boolean flag = rolePermissionService.saveBatch(list);
        return Result.check(flag);
    }
}

