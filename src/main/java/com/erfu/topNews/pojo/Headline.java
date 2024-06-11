package com.erfu.topNews.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 头条实体类
 * 该类用于表示微头条中的头条信息，包括头条的标题、文章内容、类型、发布者等信息。
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Headline implements Serializable {

    /** 头条ID */
    private Integer hid;

    /** 头条标题 */
    private String title;

    /** 头条文章内容 */
    private String article;

    /** 头条类型ID */
    private Integer type;

    /** 发布者ID */
    private Integer publisher;

    /** 浏览量 */
    private Integer pageViews;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    /** 是否删除（0-未删除，1-已删除） */
    private Integer isDeleted;
}
