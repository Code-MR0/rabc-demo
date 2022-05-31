package com.mhw.rabc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @className: MyFIle
 * @description: TODO
 * @author: mhw
 * @date: 2022/4/14
 * @version: 1.0
 **/
@Data
@ApiModel(value = "MyFile对象", description = "文件")
public class MyFile {
    @ApiModelProperty("name")
    private String name;
    @ApiModelProperty("url")
    private String url;
}
