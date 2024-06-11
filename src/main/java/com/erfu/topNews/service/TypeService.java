package com.erfu.topNews.service;

import com.erfu.topNews.pojo.Type;

import java.util.List;

/**
 * 类型相关服务接口
 * 该接口定义了对头条类型信息进行操作的方法。
 */
public interface TypeService {

    /**
     * 业务1:查询所有新闻类型
     * 查询数据库中所有的头条类型，并返回类型列表。
     *
     * @return 包含所有类型的列表
     */
    List<Type> findAll();
}
