package com.mhw.rabc.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mhw.rabc.dto.UserRoleAndOrgUpdateDTO;
import com.mhw.rabc.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @className: UserService
 * @description: UserService
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
public interface UserService extends IService<User> {

    /**
     * 新增
     *
     * @param user 用户信息
     * @return flag
     */
    boolean saveOne(User user);

    /**
     * 新增
     *
     * @param userList 用户信息
     * @return 新增失败用户信息
     */
    List<User> saveList(List<User> userList);

    /**
     * 根据用户名获取用户数据
     * @param username 用户名
     * @return 用户数据
     */
    User getUserByName(String username);


    /**
     * 根据组织id和查询条件获取用户信息
     *
     * @param user  用户信息
     * @param orgId 组织id
     * @return Page<User>
     */
    Page<User> pageListByOrg(User user, long orgId);

    /**
     * 用户分配组织和角色
     *
     * @param data 组织角色信息
     */
    void updateUserRoleAndOrg(UserRoleAndOrgUpdateDTO data);

}
