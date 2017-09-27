package com.dbapp.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by XUTAO on 2016/11/28.
 * 测试拦截器1
 */
public class HandlerInterceptor1 implements HandlerInterceptor{
    //进去Handler方法之前执行
    //用于身份认证，身份授权
    //比如身份认证，如果认证不通过表示当前用户没有登陆，需要执行此方法拦截不再向下执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //return false 表示拦截，不向下执行
        //return true 表示放行
        System.out.println("HandlerInterceptor1....preHandle");
        return true;
    }

    //进入Handler方法之后，返回modelAndView之前执行
    //应用场景从modelAndView出发:将公用的模型数据（菜单的导航）在这里传到视图，也可以在这里面统一指定视图
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("HandlerInterceptor1....postHandle");
    }

    //执行Handler完成，执行此方法
    //应用场景:统一的异常处理，统一的日志处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("HandlerInterceptor1....afterCompletion");
    }
}
