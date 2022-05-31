package com.mhw.rabc.service;

import com.mhw.rabc.dto.Result;
import com.mhw.rabc.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @className: PermissionService
 * @description: PermissionService
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
public interface PermissionService extends IService<Permission> {

    /**
     * 根据用户ID获取Menus
     *
     * @param userId userId
     * @return Result
     */
    List<Permission> getMenus(String userId);

}
