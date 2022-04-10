package com.mhw.rabc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @className: TemplateForm
 * @description: TemplateForm
 * @author: mhw
 * @date: 2022/4/10
 * @version: 1.0
 **/
@Data
@ApiModel(value = "TemplateForm对象", description = "模板结构描述")
public class TemplateForm {

    @ApiModelProperty("模板拥有者")
    private String owner;
    @ApiModelProperty("表单描述")
    private String describe;
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("封面")
    private String img;
    @ApiModelProperty("状态")
    private Boolean status;
    @ApiModelProperty("模板标题")
    private String title;
    @ApiModelProperty("模板结构数据")
    private List<FormItem> form;
    @ApiModelProperty("模板行业")
    private Industry industry;
    @ApiModelProperty("创建时间")
    private LocalDateTime gmtCreate;
}
