package com.dbapp.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @desc: 登陆认证拦截器
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/22
 * @Time： 16:38
 */
public class LoginInterceptor implements HandlerInterceptor {
    //进去Handler方法之前执行
    //用于身份认证，身份授权
    //比如身份认证，如果认证不通过表示当前用户没有登陆，需要执行此方法拦截不再向下执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginInterceptor....preHandle");
        //获取请求的url
        String url = request.getRequestURI();
        //判断url是否是公开地址，实际使用时配置配置文件中
        //这里面的公开地址是登陆地址
        if(url.indexOf("login")>0){
            //如果要进行登陆提交，放行
            return true;
        }
        //判断session
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if(username!=null){
            //如果session不为空，放行
            return true;
        }
        //执行到这里表示用户身份需要认证，跳转到登陆界面
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
        //其他不放行
        return false;
    }

    //进入Handler方法之后，返回modelAndView之前执行
    //应用场景从modelAndView出发:将公用的模型数据（菜单的导航）在这里传到视图，也可以在这里面统一指定视图
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInterceptor....postHandle");
    }

    //执行Handler完成，执行此方法
    //应用场景:统一的异常处理，统一的日志处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LoginInterceptor....afterCompletion");
    }
}
