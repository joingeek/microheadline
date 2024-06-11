package com.erfu.topNews.service;

import com.erfu.topNews.pojo.Headline;
import com.erfu.topNews.pojo.vo.HeadlineDetailVo;
import com.erfu.topNews.pojo.vo.HeadlineQueryVo;

import java.util.Map;

/**
 * 头条相关服务接口
 * 该接口定义了对头条信息进行操作的方法。
 */
public interface HeadlineService {

    /**
     * 分页查询头条信息
     * 根据查询条件进行分页查询头条信息，并返回分页结果。
     *
     * @param queryVo 头条查询条件视图对象，包含查询关键词、类型、分页信息等
     * @return 包含分页结果的 Map 对象，键为 "pageInfo"，值为分页结果信息
     */
    Map findByPage(HeadlineQueryVo queryVo);

    /**
     * 查询头条详情
     * 根据头条ID查询头条的详细信息，并返回头条详情视图对象。
     *
     * @param hid 头条ID，表示要查询的头条的唯一标识符
     * @return 头条详情视图对象，包含头条的详细信息
     */
    HeadlineDetailVo findHeadlineDetail(Integer hid);



    /**
     * 根据头条ID查询头条信息
     * 根据头条ID从数据库中查询头条信息，并返回头条对象。
     *
     * @param hid 头条ID，表示要查询的头条的唯一标识符
     * @return 查询到的头条对象，如果不存在则返回 null
     */
    Headline findByHid(int hid);

    int updateHeadline(Headline headline);

    int addHeadline(Headline headline);

    int removeHeadline(Integer hid);
}
