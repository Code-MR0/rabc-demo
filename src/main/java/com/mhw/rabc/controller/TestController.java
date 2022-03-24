package com.mhw.rabc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @ApiOperation(value = "file tes")
    @PostMapping("/file")
    public String file(@RequestParam("uploadFile") MultipartFile zipFile){
        return "hello";
    }
}
