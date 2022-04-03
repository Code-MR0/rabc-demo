package com.mhw.rabc.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mhw.rabc.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @className: UserMapper
 * @description: UserMapper
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据orgid 获取用户信息
     *
     * @param page  分页参数
     * @param orgId orgId
     * @param user  用户查询条件
     * @return 用户信息
     */
    Page<User> findAllByOrgId(@Param("page") Page<User> page, @Param("user") User user, @Param("orgId") long orgId);
}
