package com.erfu.topNews.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * 头条查询视图对象
 * 该类用于表示头条信息的查询条件视图，包括关键词、类型、分页信息等。
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HeadlineQueryVo implements Serializable {

    /** 关键词 */
    private String keyWords;

    /** 类型 */
    private Integer type;

    /** 当前页码 */
    private Integer pageNum;

    /** 每页大小 */
    private Integer pageSize;
}
