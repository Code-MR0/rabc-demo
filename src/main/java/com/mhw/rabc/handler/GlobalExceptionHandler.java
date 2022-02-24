package com.mhw.rabc.handler;


import com.mhw.rabc.dto.Result;
import com.mhw.rabc.exception.MyBaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @className: GlobalExceptionHandler
 * @description: 统一异常处理
 * @author: mhw
 * @date: 2022-02-23
 * @version 1.0
 **/
@ControllerAdvice
@Slf4j
@SuppressWarnings("rawtypes")
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.failed("执行了全局异常处理..");
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e) {
        e.printStackTrace();
        return Result.failed("执行了ArithmeticException异常处理..");
    }

    @ExceptionHandler(MyBaseException.class)
    @ResponseBody
    public Result error(MyBaseException e) {
        e.printStackTrace();
        return Result.failed(e.getMessage());
    }


}
