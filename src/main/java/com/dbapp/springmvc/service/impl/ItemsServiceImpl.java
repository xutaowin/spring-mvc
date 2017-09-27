package com.dbapp.springmvc.service.impl;

import com.dbapp.springmvc.mapper.ItemsMapper;
import com.dbapp.springmvc.pojo.Items;
import com.dbapp.springmvc.pojo.ItemsCriteria;
import com.dbapp.springmvc.pojo.ItemsQueryVo;
import com.dbapp.springmvc.service.ItemsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by XUTAO on 2016/11/23.
 */
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> queryItemsList(ItemsQueryVo itemsQueryVo) {
        return itemsMapper.selectByExample(getCriteria(itemsQueryVo));
    }

    @Override
    public Items getItemsById(Integer id) {
        return itemsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateItems(Items record) {
        return itemsMapper.updateByPrimaryKey(record);
    }

    private ItemsCriteria getCriteria(ItemsQueryVo itemsQueryVo){
        ItemsCriteria criteria = new ItemsCriteria();
        ItemsCriteria.Criteria cri = criteria.createCriteria();
        if (itemsQueryVo != null&&itemsQueryVo.getItemsCustom() != null) {
            if(StringUtils.isNotBlank(itemsQueryVo.getItemsCustom().getName())){
                cri.andNameLike(itemsQueryVo.getItemsCustom().getName());
            }
        }
        return criteria;
    }
}
