package com.dbapp.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc: 测试拦截器
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/10/11
 * @Time： 10:32
 */
@Controller
@RequestMapping(value = "/test")
public class TestInterceptor {
    @RequestMapping("/testException")
    @ResponseBody
    public String testException(){
        String s = null;
        s.length();
        return s;
    }
}
