package com.dbapp.springmvc.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc: 测试方法的优先级
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/10/2
 * @Time： 15:12
 */
@Controller
@RequestMapping(value = "/priority")
public class TestPriorityController {
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Object test1() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "其他condition相同，带有method属性的优先级高");
        return jsonObject;
    }

    @RequestMapping()
    @ResponseBody
    public Object test2() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "其他condition相同，不带method属性的优先级高");
        return jsonObject;
    }
}
