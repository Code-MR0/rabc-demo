package com.mhw.rabc.mapper;

import com.mhw.rabc.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @className: PermissionMapper
 * @description: PermissionMapper
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据用户id获取菜单
     * @param userId userId
     * @return List<Permission>
     */
    List<Permission> getMenus(String userId);

}
