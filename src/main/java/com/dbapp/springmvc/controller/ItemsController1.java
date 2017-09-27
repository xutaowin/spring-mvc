package com.dbapp.springmvc.controller;


import com.dbapp.springmvc.pojo.Items;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 非注解handler的实现
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/21
 * @Time： 10:02
 */
public class ItemsController1 implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Items> itemsList = new ArrayList<Items>();
        Items items_1 = new Items();
        items_1.setId(1);
        items_1.setName("联想笔记本");
        items_1.setPrice(8000f);

        Items items_2 = new Items();
        items_2.setId(2);
        items_2.setName("苹果笔记本");
        items_2.setPrice(18000f);

        itemsList.add(items_1);
        itemsList.add(items_2);

        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相对于request的setAttribute 在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList",itemsList);
        //定义视图
        modelAndView.setViewName("/WEB-INF/views/items/itemsList.jsp");
        return modelAndView;
    }
}
