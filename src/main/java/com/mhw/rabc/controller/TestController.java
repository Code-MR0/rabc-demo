package com.mhw.rabc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 1132493269@qq.com
 * @date 2022/2/20
 */
@Api(tags = "Test模块")
@RestController
@RequestMapping("/test")
public class TestController {
    @ApiOperation(value = "hello word!")
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
