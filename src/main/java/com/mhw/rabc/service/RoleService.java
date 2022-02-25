package com.mhw.rabc.service;

import com.mhw.rabc.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mhw.rabc.entity.User;

import java.util.List;

/**
 * @className: RoleService
 * @description: RoleService
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
public interface RoleService extends IService<Role> {

    /**
     * 新增
     *
     * @param role 角色信息
     * @return flag
     */
    boolean saveOne(Role role);

    /**
     * 新增
     *
     * @param roleList 角色信息
     * @return 新增失败角色信息
     */
    List<Role> saveList(List<Role> roleList);

}
