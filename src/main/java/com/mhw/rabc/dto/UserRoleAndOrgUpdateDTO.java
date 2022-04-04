package com.mhw.rabc.dto;

import com.mhw.rabc.entity.Role;
import lombok.Data;

import java.util.List;

/**
 * @className: UserRoleAndOrgUpdateDTO
 * @description: UserRoleAndOrgUpdateDTO
 * @author: mhw
 * @date: 2022/4/4
 * @version: 1.0
 **/
@Data
public class UserRoleAndOrgUpdateDTO {
    private Long userId;
    private List<Long> roles;
    private List<Long> organizations;
}
