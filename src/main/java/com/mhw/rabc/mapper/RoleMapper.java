package com.mhw.rabc.mapper;

import com.mhw.rabc.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mhw.rabc.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @className: RoleMapper
 * @description: RoleMapper
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户id获取角色
     * @param userId 用户id
     * @return List<Role>
     */
    List<Role> findRoleByUserId(long userId);
}
