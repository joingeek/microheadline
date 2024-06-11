package com.erfu.topNews.service.impl;

import com.erfu.topNews.mapper.UserMapper;
import com.erfu.topNews.pojo.User;
import com.erfu.topNews.service.UserService;
import com.erfu.topNews.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 * 该类实现了用户服务接口，提供了对用户信息的操作方法的具体实现。
 */
@Service
public class UserServiceImpl implements UserService {

    /** 用户数据访问对象 */
    @Autowired
    private UserMapper userMapper;


    /**
     * 注册用户
     * 将新的用户信息注册到数据库中。
     *
     * @param user 用户对象，表示要注册的用户信息
     * @return 影响的行数，表示注册操作的结果
     */
    @Override
    public int regist(User user) {
        // 对用户密码进行 MD5 加密
        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        // 调用用户数据访问对象的添加用户方法
        return userMapper.addUser(user);
    }

    /**
     * 根据用户名查询用户信息
     * 根据用户名从数据库中查询用户信息，并返回用户对象。
     *
     * @param username 用户名，表示要查询的用户的用户名
     * @return 查询到的用户对象，如果不存在则返回 null
     */
    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    /**
     * 根据用户ID查询用户信息
     * 根据用户ID从数据库中查询用户信息，并返回用户对象。
     *
     * @param uid 用户ID，表示要查询的用户的唯一标识符
     * @return 查询到的用户对象，如果不存在则返回 null
     */
    @Override
    public User findByUid(int uid) {
        return userMapper.findByUid(uid);
    }
}
