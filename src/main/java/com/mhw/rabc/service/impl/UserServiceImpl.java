package com.mhw.rabc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mhw.rabc.entity.User;
import com.mhw.rabc.exception.MyBaseException;
import com.mhw.rabc.mapper.RoleMapper;
import com.mhw.rabc.mapper.UserMapper;
import com.mhw.rabc.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: UserServiceImpl
 * @description: UserServiceImpl
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;

    @Override
    public boolean saveOne(User user) {
        if (userSaveCheck(user)) {
            throw new MyBaseException("用户名已注册");
        }
        return save(user);
    }

    @Override
    public List<User> saveList(List<User> userList) {
        List<User> saveList = new ArrayList<>(userList.size());
        List<User> saveFail = new ArrayList<>(userList.size());
        for (User user : userList) {
            if (userSaveCheck(user)) {
                saveFail.add(user);
            } else {
                saveList.add(user);
            }
        }
        boolean flag = saveBatch(saveList);
        if (!flag) {
            throw new MyBaseException("批量新增失败");
        }
        return saveFail;
    }

    @Override
    public Page<User> pageListByOrg(User user, long orgId) {
        Page<User> page = new Page<>(user.getPage(), user.getLimit());
        Page<User> userPage = userMapper.findAllByOrgId(page, user, orgId);
        userPage.getRecords().forEach(i->{
            i.setRoles(roleMapper.findRoleByUserId(i.getId()));
        });
        return userPage;
    }

    /**
     * 用户新增检查
     *
     * @param user 用户信息
     * @return flag
     */
    private boolean userSaveCheck(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        long count = count(wrapper);
        return count > 0;
    }

}

