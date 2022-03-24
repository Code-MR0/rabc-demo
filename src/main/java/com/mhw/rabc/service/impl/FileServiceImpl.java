package com.mhw.rabc.service.impl;

import com.mhw.rabc.dto.FileDTO;
import com.mhw.rabc.service.FileService;
import com.mhw.rabc.service.FormService;
import com.mhw.rabc.util.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: FileServiceImpl
 * @description: FileServiceImpl
 * @author: mhw
 * @date: 2022/3/24
 * @version: 1.0
 **/
@Service
public class FileServiceImpl implements FileService {

    OssUtil ossUtil;

    @Autowired
    public FileServiceImpl(OssUtil ossUtil) {
        this.ossUtil = ossUtil;
    }

    @Override
    public FileDTO upload(String filePath, MultipartFile zipFile) throws Throwable {
        byte[] fileBytes = zipFile.getBytes();
        FileDTO fileDTO = new FileDTO();
        String filename = zipFile.getOriginalFilename();
        String url;
        assert filename != null;
        String[] strings = filename.split("\\.");
        if ((fileBytes.length/1024)>20){
            url =  ossUtil.upload(strings[0],strings[1],filePath);
        }else {
            url = ossUtil.upload(strings[0],strings[1],fileBytes);
        }
        fileDTO.setName(filename);
        fileDTO.setUrl(url);
        return fileDTO;
    }
}
