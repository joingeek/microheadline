package com.erfu.topNews.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName news_user
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    /** 用户ID */
    private Integer uid;

    /** 用户名 */
    private String username;

    /** 用户密码 */
    private String userPwd;

    /** 用户昵称 */
    private String nickName;
}