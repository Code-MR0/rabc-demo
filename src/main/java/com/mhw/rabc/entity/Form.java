package com.mhw.rabc.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @className: Form
 * @description: Form
 * @author: mhw
 * @date: 2022/3/14
 * @version: 1.0
 **/

@Data
@ApiModel(value = "Form对象", description = "表单和模板结构描述")
public class Form {

    @ApiModelProperty("表单拥有者")
    private String owner;
    @ApiModelProperty("表单描述")
    private String describe;
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("表单标题")
    private String title;
    @ApiModelProperty("表单结构数据")
    private List<FormItem> form;
    @ApiModelProperty("创建时间")
    private LocalDateTime gmtCreate;
}
