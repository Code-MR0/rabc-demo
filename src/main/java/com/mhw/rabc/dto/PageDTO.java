package com.mhw.rabc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: PageDTO
 * @description: 分页参数工具类
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
@Data
public class PageDTO {

    @ApiModelProperty(notes  = "查询条数")
    private Integer limit;

    @ApiModelProperty(notes  = "页数")
    private Integer page;
}
