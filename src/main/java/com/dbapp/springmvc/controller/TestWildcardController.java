package com.dbapp.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/wildcard")
public class TestWildcardController {
  
  @RequestMapping("/test/**")
  @ResponseBody
  public Object test1(ModelAndView view) {
    view.addObject("attr", "TestWildcardController -> /test/**");
    return view;
  }
  
  @RequestMapping("/test/*")
  @ResponseBody
  public Object test2(ModelAndView view) {
    view.addObject("attr", "TestWildcardController -> /test*");
    return view;
  }
  
  @RequestMapping("test?")
  @ResponseBody
  public Object test3(ModelAndView view) {
    view.addObject("attr", "TestWildcardController -> test?");
    return view;
  }
  
}