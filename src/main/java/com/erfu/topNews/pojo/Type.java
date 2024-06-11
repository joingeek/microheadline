package com.erfu.topNews.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName news_type
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Type implements Serializable {
    /** 类型ID */
    private Integer tid;

    /** 类型名称 */
    private String tname;
}