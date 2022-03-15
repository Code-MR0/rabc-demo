package com.mhw.rabc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: ItemOption
 * @description: ItemOption
 * @author: mhw
 * @date: 2022/3/14
 * @version: 1.0
 **/
@Data
@ApiModel(value = "ItemOption对象", description = "选项")
public class ItemOption {

    @ApiModelProperty("label")
    private String label;
    @ApiModelProperty("value")
    private String value;
    @ApiModelProperty("是否默认选择")
    private boolean isSelect;
}
