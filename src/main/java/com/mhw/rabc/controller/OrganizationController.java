package com.mhw.rabc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mhw.rabc.dto.Result;
import com.mhw.rabc.entity.Organization;
import com.mhw.rabc.service.OrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @className: OrganizationController
 * @description: OrganizationController
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
@Slf4j
@Api(tags = "OrganizationController")
@RestController
@RequestMapping("/organization")
@SuppressWarnings("rawtypes")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    /**
     * 分页列表
     *
     * @param organization 分页信息
     */
    @ApiOperation(value = "分页列表")
    @GetMapping("/pageList")
    public Result pageList(Organization organization) {
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>(organization);
        Page<Organization> page = new Page<>(organization.getPage(), organization.getLimit());
        Page<Organization> pageList = organizationService.page(page, queryWrapper);
        return Result.success(pageList);
    }

    /**
     * list列表
     *
     * @param organization 查询条件
     */
    @ApiOperation(value = "list列表")
    @GetMapping("/list")
    public Result list(Organization organization) {
        // todo 组织树形结构封装
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>(organization);
        List<Organization> organizationList = organizationService.list(queryWrapper);
        return Result.success(organizationList);
    }

    /**
     * 根据主键查询
     *
     * @param id 主键id
     */
    @ApiOperation(value = "根据主键查询")
    @GetMapping("/info/getById")
    public Result info(@RequestParam("id") Long id) {
        Organization organization = organizationService.getById(id);
        return Result.success(organization);
    }

    /**
     * 新增
     *
     * @param organization 组织/机构信息
     */
    @ApiOperation(value = "新增")
    @PostMapping("/saveOne")
    public Result saveOne(@RequestBody Organization organization) {
        boolean flag = organizationService.save(organization);
        return Result.check(flag);
    }

    /**
     * 批量新增
     *
     * @param organizationList 组织/机构信息
     */
    @ApiOperation(value = "批量新增")
    @PostMapping("/save")
    public Result save(@RequestBody List<Organization> organizationList) {
        boolean flag = organizationService.saveBatch(organizationList);
        return Result.check(flag);
    }

    /**
     * 更新
     *
     * @param organization 组织/机构信息
     */
    @ApiOperation(value = "更新")
    @PostMapping("/updateById")
    public Result updateById(@RequestBody Organization organization) {
        boolean flag = organizationService.updateById(organization);
        return Result.check(flag);
    }

    /**
     * 批量更新
     *
     * @param organizationList 组织/机构信息
     */
    @ApiOperation(value = "批量更新")
    @PostMapping("/update")
    public Result update(@RequestBody List<Organization> organizationList) {
        boolean flag = organizationService.updateBatchById(organizationList);
        return Result.check(flag);
    }

    /**
     * 删除
     *
     * @param organization 组织/机构信息
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/removeById")
    public Result removeById(@RequestBody Organization organization) {
        // todo 删除下属组织/机构,同时解除组织/机构和用户的关联关系
        boolean flag = organizationService.removeById(organization);
        return Result.check(flag);
    }

    /**
     * 批量删除
     *
     * @param organizationList 组织/机构信息
     */
    @ApiOperation(value = "批量删除")
    @DeleteMapping("/remove")
    public Result remove(@RequestBody List<Organization> organizationList) {
        boolean flag = organizationService.removeByIds(organizationList);
        return Result.check(flag);
    }

}

