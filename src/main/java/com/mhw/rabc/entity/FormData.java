package com.mhw.rabc.entity;

import com.mhw.rabc.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "FormData对象", description = "表单数据")
public class FormData extends PageDTO {

    @ApiModelProperty("表单填写者")
    private String owner;
    @ApiModelProperty("表单描述")
    private String describe;
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("formId")
    private String formId;
    @ApiModelProperty("表单数据")
    private List<FormItem> form;
    @ApiModelProperty("创建时间")
    private LocalDateTime gmtCreate;
}
