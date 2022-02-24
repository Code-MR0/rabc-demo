package com.mhw.rabc.service;

import com.mhw.rabc.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * @return flag
     */
    List<User> saveList(List<User> userList);

}
