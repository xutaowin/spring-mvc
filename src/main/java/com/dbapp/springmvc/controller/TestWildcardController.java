package com.dbapp.springmvc.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/wildcard")
public class TestWildcardController {
  
  @RequestMapping("/test/**")
  @ResponseBody
  public Object test1() {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("message", "TestWildcardController -> /test/**");
    return jsonObject;
  }
  
  @RequestMapping("/test/*")
  @ResponseBody
  public Object test2() {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("message", "TestWildcardController -> /test/*");
    return jsonObject;
  }
  
  @RequestMapping("test?")
  @ResponseBody
  public Object test3() {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("message", "TestWildcardController -> test?");
    return jsonObject;
  }

  @RequestMapping("test*")
  @ResponseBody
  public Object test4() {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("message", "TestWildcardController -> test*");
    return jsonObject;
  }
  
}