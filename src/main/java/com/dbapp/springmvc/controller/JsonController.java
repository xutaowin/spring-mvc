package com.dbapp.springmvc.controller;

import com.dbapp.springmvc.pojo.ItemsCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by XUTAO on 2016/11/28.
 * json请求响应的测试
 */
@Controller
public class JsonController {

    @RequestMapping("jsonTest")
    public String jsonTest(){
        return "jsonTest";
    }
    //请求json串(商品信息)，输出响应json(商品信息)
    //@RequestBody将请求的商品信息的json串转成itemsCustom
    //@ResponseBody将itemsCustom转化成json输出
    @RequestMapping("requestJson")
    @ResponseBody
    public ItemsCustom requestJson(@RequestBody  ItemsCustom itemsCustom){
        //@ResponseBody将itemsCustom转化成json输出
        return itemsCustom;
    }

    //请求key/value串(商品信息)，输出响应json(商品信息)
    //@ResponseBody将itemsCustom转化成json输出
    @RequestMapping("requestKeyValue")
    @ResponseBody
    public ItemsCustom requestKeyValue(ItemsCustom itemsCustom){
        //@ResponseBody将itemsCustom转化成json输出
        return itemsCustom;
    }
}
