package com.lfw.controller;

import com.lfw.exception.BusinessException;
import com.lfw.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice用于标识当前类为REST风格对应的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {
//    //除了自定义的异常处理器，保留对 Exception 类型的异常处理，用于处理非预期的异常
//    @ExceptionHandler(Exception.class)
//    public Result doException(Exception ex) {
//        System.out.println("嘿嘿，异常你哪里跑！");
//        return new Result(666, null, "嘿嘿，异常你哪里跑！");
//    }

    //@ExceptionHandler用于设置当前处理器类对应的异常类型
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex) {
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员，ex对象送给开发人员
        return new Result(ex.getCode(), null, ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex) {
        return new Result(ex.getCode(), null, ex.getMessage());
    }

    //除了自定义的异常处理器，保留对Exception类型的异常处理，用于处理非预期的异常
    @ExceptionHandler(Exception.class)
    public Result doOtherException(Exception ex) {
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员，ex对象送给开发人员
        return new Result(Code.SYSTEM_UNKNOWN_ERR, null, "系统繁忙，请稍后再试！");
    }
}
