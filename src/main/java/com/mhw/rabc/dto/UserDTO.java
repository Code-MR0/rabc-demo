package com.mhw.rabc.dto;

import com.mhw.rabc.entity.Organization;
import com.mhw.rabc.entity.Role;
import com.mhw.rabc.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @className: UserDTO
 * @description: TODO
 * @author: mhw
 * @date: 2022/4/3
 * @version: 1.0
 **/
@Data
public class UserDTO {
    @ApiModelProperty(notes = "用户信息")
    private User user;
    @ApiModelProperty(notes = "角色信息")
    private List<Role> roles;
    @ApiModelProperty(notes = "组织信息")
    private List<Organization> organizations;
}
