package com.erfu.topNews.service.impl;

import com.erfu.topNews.mapper.TypeMapper;
import com.erfu.topNews.pojo.Type;
import com.erfu.topNews.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类型服务实现类
 * 该类实现了类型服务接口，提供了对头条类型信息的操作方法的具体实现。
 */
@Service
public class TypeServiceImpl implements TypeService {

    /** 类型数据访问对象 */
    @Autowired
    private  TypeMapper typeMapper;

    /**
     * 业务1:查询所有类型
     * 查询数据库中所有的头条类型，并返回类型列表。
     *
     * @return 包含所有类型的列表
     */
    @Override
    public List<Type> findAll() {
        return typeMapper.findAll();
    }
}
