package com.dbapp.springmvc.controller;

import com.dbapp.springmvc.pojo.Items;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 非注解handler的实现
 */
public class ItemsController2 implements HttpRequestHandler {
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        request.setAttribute("itemsList",itemsList);
        request.getRequestDispatcher("/WEB-INF/views/items/itemsList.jsp").forward(request,response);
    }
}
