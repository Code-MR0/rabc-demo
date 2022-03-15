package com.mhw.rabc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mhw.rabc.entity.Role;
import com.mhw.rabc.entity.User;
import com.mhw.rabc.exception.MyBaseException;
import com.mhw.rabc.mapper.RoleMapper;
import com.mhw.rabc.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: RoleServiceImpl
 * @description: RoleServiceImpl
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public boolean saveOne(Role role) {
        if (roleSaveCheck(role)) {
            throw new MyBaseException("角色名或角色代码已注册");
        }
        return save(role);
    }

    @Override
    public List<Role> saveList(List<Role> roleList) {
        List<Role> saveList = new ArrayList<>(roleList.size());
        List<Role> saveFail = new ArrayList<>(roleList.size());
        for (Role role:roleList) {
            if (roleSaveCheck(role)){
                saveFail.add(role);
            }else {
                saveList.add(role);
            }
        }
        boolean flag = saveBatch(saveList);
        if (!flag){
        }
        return saveFail;
    }

    /**
     * 用户新增检查
     *
     * @param role 角色信息
     * @return flag
     */
    private boolean roleSaveCheck(Role role) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name", role.getRoleName());
        wrapper.or();
        wrapper.eq("role_code", role.getRoleCode());
        long count = count(wrapper);
        return count > 0;
    }
}
