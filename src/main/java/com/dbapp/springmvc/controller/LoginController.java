package com.dbapp.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by XUTAO on 2016/11/29.
 */
@Controller
public class LoginController {

    @RequestMapping("loginPage")
    public String jsonTest(){
        return "login";
    }

    //登录
    @RequestMapping(value = "login")
    public String login(HttpSession session,String username,String password) throws Exception{
        // TODO: 调用service进行身份认证
        // 在session中保存用户信息
        session.setAttribute("username",username);
        //重定向到商品列表界面
        return "redirect:/items/queryItemsList";
    }
    //退出
    @RequestMapping(value = "logout")
    public String logout(HttpSession session) throws Exception{
        // 清除session
        session.invalidate();
        //重定向到商品列表界面
        return "redirect:/items/queryItemsList";
    }
}
