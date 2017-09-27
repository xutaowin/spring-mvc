package com.dbapp.springmvc.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by XUTAO on 2016/11/26.
 */
public class ItemsDateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //参数绑定成功就直接返回
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 参数绑定失败返回null
        return null;
    }
}
