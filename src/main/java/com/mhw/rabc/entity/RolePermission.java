package com.mhw.rabc.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @className: RolePermission
 * @description: RolePermission对象
 * @author: mhw
 * @date: 2022-04-06
 * @version: 1.0
 **/
@Getter
@Setter
@TableName("role_permission")
@ApiModel(value = "RolePermission对象", description = "用户权限关联表")
@AllArgsConstructor
@NoArgsConstructor
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    public RolePermission(Long roleId, Long permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("角色Id")
    private Long roleId;

    @ApiModelProperty("权限id")
    private Long permissionId;

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

    @ApiModelProperty(notes = "权限信息")
    @TableField(exist = false)
    private List<Permission> permissions;

}
