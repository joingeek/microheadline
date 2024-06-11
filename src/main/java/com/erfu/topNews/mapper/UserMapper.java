package com.erfu.topNews.mapper;

import com.erfu.topNews.pojo.User;

/**
* @author ErFu
* @description 针对表【news_user】的数据库操作Mapper
* @createDate 2024-06-01 16:32:20
* @Entity com.erfu.topNews.pojo.User
*/
public interface UserMapper {
    /**
     * 根据用户名查询用户
     * 该方法根据用户名从数据库中查询用户信息，并返回用户对象。
     *
     * @param username 用户名，表示要查询的用户的用户名
     * @return 查询到的用户对象，如果不存在则返回 null
     */
    User findByUsername(String username);

    /**
     * 添加用户
     * 该方法将用户信息添加到数据库中。
     *
     * @param user 用户对象，表示要添加的用户信息
     * @return 影响的行数，表示添加操作的结果
     */
    int addUser(User user);

    /**
     * 根据用户ID查询用户
     * 该方法根据用户ID从数据库中查询用户信息，并返回用户对象。
     *
     * @param uid 用户ID，表示要查询的用户的唯一标识符
     * @return 查询到的用户对象，如果不存在则返回 null
     */
    User findByUid(int uid);
}
