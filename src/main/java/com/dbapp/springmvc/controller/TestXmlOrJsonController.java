package com.dbapp.springmvc.controller;

import com.dbapp.springmvc.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc: 关于json和xml自动转换
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/10/4
 * @Time： 20:19
 */
@Controller
@RequestMapping("/test")
public class TestXmlOrJsonController {
    @RequestMapping("/xmlOrJson")
    @ResponseBody
    public Map<String, Object> xmlOrJson() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Employee> list = new ArrayList<Employee>();
        for(int i=0;i<5;i++){
            Employee employee = new Employee(i,"name"+i,i+10,i*100);
            list.add(employee);
        }
        map.put("list", list);
        return map;
    }

    @RequestMapping("/xmlOrJsonSimple")
    @ResponseBody
    public Employee  xmlOrJsonSimple() {
        Employee employee = new Employee(1,"name1",1+10,1*100);
        return employee;
    }
}
