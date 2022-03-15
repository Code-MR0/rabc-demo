package com.mhw.rabc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @className: FormItem
 * @description: FormItem
 * @author: mhw
 * @date: 2022/3/14
 * @version: 1.0
 **/
@Data
@ApiModel(value = "FormItem对象", description = "表单项")
public class FormItem {

    @ApiModelProperty("表单项拥有者")
    private String owner;
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("label")
    private String label;
    @ApiModelProperty("type")
    private String type;
    @ApiModelProperty("itemOptions")
    private List<ItemOption> values;

}
