package com.dbapp.springmvc.service;

import com.dbapp.springmvc.pojo.Items;
import com.dbapp.springmvc.pojo.ItemsQueryVo;

import java.util.List;

/**
 * Created by XUTAO on 2016/11/23.
 */
public interface ItemsService {
    /**
     * 商品查询列表
     * @param itemsQueryVo
     * @return
     */
    List<Items> queryItemsList(ItemsQueryVo itemsQueryVo) ;

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    Items getItemsById(Integer id);

    /**
     * 根据id更新商品
     * @param record
     * @return
     */
    int updateItems(Items record);
}
