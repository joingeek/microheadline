package com.erfu.topNews.service;

import com.erfu.topNews.pojo.User;

/**
 * 用户相关服务接口
 * 该接口定义了对用户信息进行操作的方法。
 */
public interface UserService {

    /**
     * 注册用户
     * 将新的用户信息注册到数据库中。
     *
     * @param user 用户对象，表示要注册的用户信息
     * @return 影响的行数，表示注册操作的结果
     */
    int regist(User user);

    /**
     * 根据用户名查询用户信息
     * 根据用户名从数据库中查询用户信息，并返回用户对象。
     *
     * @param username 用户名，表示要查询的用户的用户名
     * @return 查询到的用户对象，如果不存在则返回 null
     */
    User findByUsername(String username);

    /**
     * 根据用户ID查询用户信息
     * 根据用户ID从数据库中查询用户信息，并返回用户对象。
     *
     * @param uid 用户ID，表示要查询的用户的唯一标识符
     * @return 查询到的用户对象，如果不存在则返回 null
     */
    User findByUid(int uid);
}
