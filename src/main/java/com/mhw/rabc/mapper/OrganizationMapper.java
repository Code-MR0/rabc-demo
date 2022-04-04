package com.mhw.rabc.mapper;

import com.mhw.rabc.entity.Organization;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mhw.rabc.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @className: OrganizationMapper
 * @description: OrganizationMapper
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
@Mapper
public interface OrganizationMapper extends BaseMapper<Organization> {

    /**
     * 根据用户id获取角色
     * @param userId 用户id
     * @return List<Role>
     */
    List<Organization> findOrgByUserId(long userId);
}
