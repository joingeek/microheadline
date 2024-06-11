package com.erfu.topNews.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * 头条详情视图对象
 * 该类用于表示头条的详细信息视图，包括头条的标题、文章内容、类型、浏览量等信息。
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HeadlineDetailVo implements Serializable {

    /** 头条ID */
    private Integer hid;

    /** 头条标题 */
    private String title;

    /** 头条文章内容 */
    private String article;

    /** 头条类型ID */
    private Integer type;

    /** 头条类型名称 */
    private String typeName;

    /** 浏览量 */
    private Integer pageViews;

    /** 距现在的小时数 */
    private Long pastHours;

    /** 发布者ID */
    private Integer publisher;

    /** 作者名称 */
    private String author;
}
