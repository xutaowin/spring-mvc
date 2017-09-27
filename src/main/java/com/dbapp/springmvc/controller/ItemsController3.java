package com.dbapp.springmvc.controller;

import com.dbapp.springmvc.pojo.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 注解handler的实现
 */
@Controller
@RequestMapping("/items")
public class ItemsController3 {
    //商品查询列表
    @RequestMapping("/queryItems3")
    public ModelAndView queryItems() throws Exception{
        List<Items> itemsList = new ArrayList<Items>();
        Items items_1 = new Items();
        items_1.setId(1);
        items_1.setName("联想笔记本");
        items_1.setPrice(8888f);

        Items items_2 = new Items();
        items_2.setId(2);
        items_2.setName("苹果笔记本");
        items_2.setPrice(18888f);

        itemsList.add(items_1);
        itemsList.add(items_2);

        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相对于request的setAttribute 在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList",itemsList);
        //定义视图 如果在视图解析器中配置了前缀和后缀
        //modelAndView.setViewName("/WEB-INF/views/items/itemsList.jsp");
        //可以修改成如下
        modelAndView.setViewName("items/addItemsTest");
        return modelAndView;
    }

    @RequestMapping("/saveAddTest")
    public ModelAndView queryItems(Items items) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("items/addItemsTest");
        return modelAndView;
    }
}
