package com.mhw.rabc.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.mhw.rabc.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @className: Role
 * @description: Role对象
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Role对象", description = "角色表")
public class Role extends PageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("角色名")
    private String roleName;

    @ApiModelProperty("角色编码")
    private String roleCode;

    @ApiModelProperty("逻辑删除")
    @TableLogic
    private Integer isDelete;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @ApiModelProperty("版本")
    @Version
    private Integer version;


}
