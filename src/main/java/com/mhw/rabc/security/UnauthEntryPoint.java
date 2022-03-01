package com.mhw.rabc.security;


import com.mhw.rabc.dto.Result;
import com.mhw.rabc.util.ResponseUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * @className: UnauthEntryPoint
 * @description: UnauthEntryPoint
 * @author: mhw
 * @date: 2022-03-01
 **/
public class UnauthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResponseUtil.out(httpServletResponse, Result.failed(403,"权限异常",null));
    }
}
