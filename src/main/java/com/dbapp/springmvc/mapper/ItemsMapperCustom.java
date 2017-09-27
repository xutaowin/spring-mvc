package com.dbapp.springmvc.mapper;

import com.dbapp.springmvc.pojo.Items;
import com.dbapp.springmvc.pojo.ItemsCustom;
import com.dbapp.springmvc.pojo.ItemsQueryVo;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：items
 * @since 2016-11-23 22:46:43
 */
public interface ItemsMapperCustom {
    List<ItemsCustom> queryItemsList(ItemsQueryVo itemsQueryVo);
    List<ItemsCustom> queryItemsList2();
    int insert(Items items);
}