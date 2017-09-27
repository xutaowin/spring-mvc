package com.dbapp.springmvc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by XUTAO on 2016/11/27.
 * 全局异常处理器
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{
    /**
     *
     * @param request
     * @param response
     * @param handler
     * @param ex 系统抛出来的异常
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //handler就是处理器适配器要执行的Handler对象
        //解析异常类型
        //如果该异常类是系统自定义的异常，直接取出异常信息，在错误页面展示
        String message = null;
        /*if(ex instanceof CustomException){
            message = ((CustomException)ex).getMessage();
        }else{
            //如果该异常类型不是系统自定义的异常，构建一个自定义的异常类型（信息为“未知错误”）
            message = "未知错误";
        }*/
        CustomException customException = null;
        if(ex instanceof CustomException){
            customException = (CustomException)ex;
        }else{
            customException = new CustomException("未知错误");
        }
        message = customException.getMessage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",message);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
