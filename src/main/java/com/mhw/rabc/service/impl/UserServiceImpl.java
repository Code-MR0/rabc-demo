package com.mhw.rabc.service.impl;

import com.mhw.rabc.entity.User;
import com.mhw.rabc.mapper.UserMapper;
import com.mhw.rabc.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @className: UserServiceImpl
 * @description: UserServiceImpl
 * @author: mhw
 * @date: 2022-02-23
 * @version: 1.0
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
