package com.mhw.rabc.entity;

import com.mhw.rabc.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @className: Industry
 * @description: 行业
 * @author: mhw
 * @date: 2022/4/10
 * @version: 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "行业", description = "行业分类")
public class Industry  extends PageDTO {
    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("行业名")
    private String name;

    @ApiModelProperty("创建时间")
    private LocalDateTime gmtCreate;
}
