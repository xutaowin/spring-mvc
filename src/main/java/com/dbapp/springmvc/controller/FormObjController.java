package com.dbapp.springmvc.controller;

import com.dbapp.springmvc.annotation.FormObj;
import com.dbapp.springmvc.pojo.Dept;
import com.dbapp.springmvc.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/foc")
public class FormObjController {
  
    @RequestMapping("/test1")
    public String test1(@FormObj Dept dept, @FormObj Employee emp) {
        return "index";
    }
    
    @RequestMapping("/test2")
    public String test2(@FormObj("d") Dept dept, @FormObj("e") Employee emp) {
        return "index";
    }
    
    @RequestMapping("/test3")
    public String test3(@FormObj(value = "d", show = false) Dept dept, @FormObj("e") Employee emp) {
        return "index";
    }
  
}