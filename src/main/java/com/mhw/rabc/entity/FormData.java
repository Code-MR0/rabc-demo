package com.mhw.rabc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @className: FormData
 * @description: FormData
 * @author: mhw
 * @date: 2022/3/28
 * @version: 1.0
 **/


@Data
@ApiModel(value = "FormData对象", description = "表单数据")
public class FormData{

    @ApiModelProperty("表单填写者")
    private String owner;
    @ApiModelProperty("表单描述")
    private String describe;
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("表单数据")
    private List<FormItem> form;
    @ApiModelProperty("创建时间")
    private LocalDateTime gmtCreate;
}
