package com.erfu.topNews.mapper;

import com.erfu.topNews.pojo.Type;

import java.util.List;

/**
* @author ErFu
* @description 针对表【news_type】的数据库操作Mapper
* @createDate 2024-06-01 16:32:20
* @Entity com.erfu.topNews.pojo.Type
*/
public interface TypeMapper {
   //业务1:查询所有新闻类型,调用xml
   List<Type> findAll();
}
