package com.mhw.rabc.service;

import com.mhw.rabc.dto.FileDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @className: FileService
 * @description: FileService
 * @author: mhw
 * @date: 2022/3/24
 * @version: 1.0
 **/
public interface FileService {

    /**
     * 上传文件 根据文件类型和大小选择不同方式
     * @param filePath 文件路径
     * @param zipFile 文件
     * @return 文件url
     * @throws Throwable IOException
     */
    FileDTO upload(String filePath, MultipartFile zipFile) throws Throwable;
}
