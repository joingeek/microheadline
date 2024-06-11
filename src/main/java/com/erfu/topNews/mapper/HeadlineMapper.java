package com.erfu.topNews.mapper;

import com.erfu.topNews.pojo.Headline;
import com.erfu.topNews.pojo.vo.HeadlineDetailVo;
import com.erfu.topNews.pojo.vo.HeadlinePageVo;
import com.erfu.topNews.pojo.vo.HeadlineQueryVo;

import java.util.List;

/**
* @author ErFu
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2024-06-01 16:32:20
* @Entity com.erfu.topNews.pojo.Headline
*/
public interface HeadlineMapper {

    /**
     * 业务2:根据查询条件查询头条信息列表
     * 该方法根据查询条件查询头条信息列表，并返回符合条件的头条信息列表。
     *
     * @param queryVo 查询条件对象，包含了查询头条信息的条件
     * @return 符合条件的头条信息列表
     */
    List<HeadlinePageVo> findByQueryVo(HeadlineQueryVo queryVo);
    
    /**
     * 增加头条浏览量
     * 该方法用于增加指定头条的浏览量。
     *
     * @param hid 头条ID，表示要增加浏览量的头条的唯一标识符
     * @return 影响的行数，表示浏览量增加操作的结果
     */
    void increasePageViews(Integer hid);

    /**
     * 根据头条ID查询头条详情
     * 该方法根据头条ID查询头条的详细信息，并返回头条详情对象。
     *
     * @param hid 头条ID，表示要查询的头条的唯一标识符
     * @return 头条详情对象，包含了头条的详细信息
     */
    HeadlineDetailVo findHeadlineDetail(Integer hid);

    Headline findByHid(int hid);

    int updateHeadline(Headline headline);

    int addHeadline(Headline headline);

    int removeByHid(Integer hid);
}
