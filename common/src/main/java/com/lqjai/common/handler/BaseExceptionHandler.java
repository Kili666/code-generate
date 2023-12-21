package com.lqjai.common.handler;

import com.lqjai.common.utils.R;
import com.lqjai.common.utils.StatusCode;
import com.lqjai.common.exception.ServiceException;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */
@ControllerAdvice
@Configuration
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return new R(false, StatusCode.ERROR, e.getMessage());
    }

    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public R error(ServiceException e) {
        e.printStackTrace();
        return new R(false,e.getCode(), e.getMessage());
    }
}