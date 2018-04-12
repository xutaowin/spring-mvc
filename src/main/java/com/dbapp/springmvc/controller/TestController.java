package com.dbapp.springmvc.controller;

import com.dbapp.springmvc.pojo.Employee;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/test")
public class TestController {
  
  @RequestMapping("/testRb")
  @ResponseBody
  public Employee testRb(@RequestBody Employee e) {
    return e;
  }
  
  @RequestMapping("/testCustomObj")
  @ResponseBody
  public Employee testCustomObj(Employee e) {
    return e;
  }
  
  @RequestMapping("/testCustomObjWithRp")
  @ResponseBody
  public Employee testCustomObjWithRp(@RequestParam Employee e) {
    return e;
  }
  
  @RequestMapping("/testDate")
  @ResponseBody
  public Date testDate(Date date) {
    return date;
  }

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
  }
  
}