package com.mhw.rabc.controller;

import com.mhw.rabc.dto.Result;
import com.mhw.rabc.service.FileService;
import com.mhw.rabc.util.OssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;


/**
 * @className: FileController
 * @description: FileController
 * @author: mhw
 * @date: 2022/3/24
 * @version: 1.0
 **/
@Api(tags = "FileController")
@RestController
@RequestMapping("/file")
@SuppressWarnings("rawtypes")
public class FileController {

    FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @ApiOperation(value = "上传文件")
    @PostMapping("/upload")
    public Result upload(@RequestParam("filePath") String filePath,@RequestParam("uploadFile") MultipartFile zipFile) throws Throwable {
        return Result.success(fileService.upload(filePath, zipFile));
    }
}
