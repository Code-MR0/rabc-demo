package com.mhw.rabc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mhw.rabc.dto.Result;
import com.mhw.rabc.entity.User;
import com.mhw.rabc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @className: UserController
 * @description: UserController
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
@Slf4j
@Api(tags = "UserController")
@RestController
@RequestMapping("/user")
@SuppressWarnings("rawtypes")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * 分页列表
     *
     * @param user 分页信息
     */
    @ApiOperation(value = "分页列表")
    @GetMapping("/pageList")
    public Result pageList(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(user.getUsername()!=null){
            queryWrapper.like("username",user.getUsername());
        }
        if (user.getUsername() == null && user.getNickName() != null) {
            queryWrapper.like("nick_name", user.getNickName());
        }
        if (user.getUsername() != null && user.getNickName() != null) {
            queryWrapper.or();
            queryWrapper.like("nick_name", user.getNickName());
        }
        Page<User> page = new Page<>(user.getPage(), user.getLimit());
        Page<User> pageList = userService.page(page, queryWrapper);
        return Result.success(pageList);
    }

    /**
     * list列表
     *
     * @param user 查询条件
     */
    @ApiOperation(value = "list列表")
    @GetMapping("/list")
    public Result list(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        List<User> userList = userService.list(queryWrapper);
        return Result.success(userList);
    }

    /**
     * 根据主键查询
     *
     * @param id 主键id
     */
    @ApiOperation(value = "根据主键查询")
    @GetMapping("/info/getById")
    public Result info(@RequestParam("id") Long id) {
        User user = userService.getById(id);
        return Result.success(user);
    }

    /**
     * 新增
     *
     * @param user 用户信息
     */
    @ApiOperation(value = "新增")
    @PostMapping("/saveOne")
    public Result saveOne(@RequestBody User user) {
        boolean flag = userService.saveOne(user);
        return Result.check(flag);
    }

    /**
     * 批量新增
     *
     * @param userList 用户信息
     */
    @ApiOperation(value = "批量新增")
    @PostMapping("/save")
    public Result save(@RequestBody List<User> userList) {
        List<User> list = userService.saveList(userList);
        if (list.size()==0){
            return Result.success();
        }
        return Result.failed("部分用户添加失败",list);
    }

    /**
     * 更新
     *
     * @param user 用户信息
     */
    @ApiOperation(value = "更新")
    @PostMapping("/updateById")
    public Result updateById(@RequestBody User user) {
        boolean flag = userService.updateById(user);
        return Result.check(flag);
    }

    /**
     * 批量更新
     *
     * @param userList 用户信息
     */
    @ApiOperation(value = "批量更新")
    @PostMapping("/update")
    public Result update(@RequestBody List<User> userList) {
        boolean flag = userService.updateBatchById(userList);
        return Result.check(flag);
    }

    /**
     * 删除
     *
     * @param user 用户信息
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/removeById")
    public Result removeById(@RequestBody User user) {
        boolean flag = userService.removeById(user);
        return Result.check(flag);
    }

    /**
     * 批量删除
     *
     * @param userList 用户信息
     */
    @ApiOperation(value = "批量删除")
    @DeleteMapping("/remove")
    public Result remove(@RequestBody List<User> userList) {
        boolean flag = userService.removeByIds(userList);
        return Result.check(flag);
    }

}

