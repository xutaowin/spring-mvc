package com.dbapp.springmvc.pojo;

import java.util.List;
import java.util.Map;

public class ItemsQueryVo{
    //商品信息
    private Items items;
    //为了系统可扩展性，对原始生成的pojo进行扩展
    private ItemsCustom itemsCustom;

    //批量修改商品
    private List<ItemsCustom> itemsList;

    //新增商品信息
    private Map<String,Object> itemsInfo;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }

    public List<ItemsCustom> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemsCustom> itemsList) {
        this.itemsList = itemsList;
    }

    public Map<String, Object> getItemsInfo() {
        return itemsInfo;
    }

    public void setItemsInfo(Map<String, Object> itemsInfo) {
        this.itemsInfo = itemsInfo;
    }
}