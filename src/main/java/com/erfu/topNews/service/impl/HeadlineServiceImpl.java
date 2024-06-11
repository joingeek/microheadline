package com.erfu.topNews.service.impl;

import com.erfu.topNews.mapper.HeadlineMapper;
import com.erfu.topNews.pojo.Headline;
import com.erfu.topNews.pojo.vo.HeadlineDetailVo;
import com.erfu.topNews.pojo.vo.HeadlinePageVo;
import com.erfu.topNews.pojo.vo.HeadlineQueryVo;
import com.erfu.topNews.service.HeadlineService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务1:头条服务实现类
 * 该类实现了头条服务接口，提供了对头条信息的操作方法的具体实现。
 */
@Service
public class HeadlineServiceImpl implements HeadlineService {


    private final HeadlineMapper headlineMapper;

    public HeadlineServiceImpl(HeadlineMapper headlineMapper) {
        this.headlineMapper = headlineMapper;
    }

    /**
     * 业务2:分页查询头条信息
     * 根据查询条件进行分页查询头条信息，并返回分页结果。
     *
     * @param queryVo 查询条件对象，包含关键字、类型、页码和每页大小等信息
     * @return 包含分页信息的 Map 对象，包括当前页数据、页码、每页大小、总页数和总记录数等信息
     */
    @Override
    public Map<String, Object> findByPage(HeadlineQueryVo queryVo) {

        //开启分页插件
        PageHelper.startPage(queryVo.getPageNum(),queryVo.getPageSize());
        List<HeadlinePageVo> list=headlineMapper.findByQueryVo(queryVo);

        PageInfo pageInfo=new PageInfo(list);
        Map pageInfoMap=new HashMap();
        pageInfoMap.put("pageData",list);
        pageInfoMap.put("pageNum",pageInfo.getPageNum());
        pageInfoMap.put("pageSize",pageInfo.getPageSize());
        pageInfoMap.put("totalPage",pageInfo.getPages());
        pageInfoMap.put("totalSize",pageInfo.getTotal());
        return pageInfoMap;
    }


    /**
     * 业务3:查询头条详细信息
     * 根据头条ID查询头条详细信息，并增加浏览量。
     *
     * @param hid 头条ID，表示要查询的头条的唯一标识符
     * @return 头条详细信息对象
     */
    @Override
    public HeadlineDetailVo findHeadlineDetail(Integer hid) {
        headlineMapper.increasePageViews(hid);
        return headlineMapper.findHeadlineDetail(hid);
    }

    /**
     * 根据头条ID查询头条信息
     * 根据头条ID从数据库中查询头条信息，并返回头条对象。
     *
     * @param hid 头条ID，表示要查询的头条的唯一标识符
     * @return 查询到的头条对象，如果不存在则返回 null
     */
    @Override
    public Headline findByHid(int hid) {
        return headlineMapper.findByHid(hid);
    }

    /**
     * 更新头条信息
     * 更新数据库中指定头条的信息。
     *
     * @param headline 头条对象，表示要更新的头条信息
     * @return 影响的行数，表示更新操作的结果
     */
    @Override
    public int updateHeadline(Headline headline) {

        return headlineMapper.updateHeadline(headline);
    }

    @Override
    public int addHeadline(Headline headline) {
        return headlineMapper.addHeadline(headline);
    }

    /**
     * 删除头条信息
     * 根据头条ID从数据库中删除指定的头条信息。
     *
     * @param hid 头条ID，表示要删除的头条的唯一标识符
     * @return 影响的行数，表示删除操作的结果
     */
    @Override
    public int removeHeadline(Integer hid) {
        return headlineMapper.removeByHid(hid);
    }
}
