package com.mhw.rabc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;

/**
 * @className: Check
 * @description: Check
 * @author: mhw
 * @date: 2022/3/27
 * @version: 1.0
 **/
@Data
@ApiModel(value = "多选项选择值", description = "多选项选择值")
public class Check {
    @ApiModelProperty("多选框")
    private ArrayList<String> checkBox;
    @ApiModelProperty("单选框")
    private String radio;
    @ApiModelProperty("下拉单选框")
    private String select;
    @ApiModelProperty("下拉多选框")
    private ArrayList<String> selects;
}
