package com.mhw.rabc.service.impl;

import com.mhw.rabc.dto.Result;
import com.mhw.rabc.entity.Permission;
import com.mhw.rabc.mapper.PermissionMapper;
import com.mhw.rabc.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: PermissionServiceImpl
 * @description: PermissionServiceImpl
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    PermissionMapper permissionMapper;

    @Autowired
    public PermissionServiceImpl(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public List<Permission> getMenus(String userId) {
        return permissionMapper.getMenus(userId);
    }
}
