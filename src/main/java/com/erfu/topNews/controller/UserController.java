package com.erfu.topNews.controller;

import com.erfu.topNews.commons.Result;
import com.erfu.topNews.commons.ResultCodeEnum;
import com.erfu.topNews.pojo.User;
import com.erfu.topNews.service.UserService;
import com.erfu.topNews.utils.JwtHelper;
import com.erfu.topNews.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * UserController
 * <p>
 * 该类用于处理用户相关的请求，包括登录、注册、检查登录状态、检查用户名、获取用户信息等。
 * <p>
 * 主要职责：
 * 1. 接收并处理前端关于用户的请求。
 * 2. 调用对应的Service层方法进行业务处理。
 * 3. 返回处理结果给前端。
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;// 自动注入 UserService，用于处理用户相关业务

    /**
     * 检查用户是否已登录
     *
     * @param token 用户的token
     * @return 返回检查结果
     */
    @GetMapping("checkLogin")
    public Result checkLogin(@RequestHeader(value = "token", required = false) String token) {
        // 默认返回未登录的结果
        Result result = Result.build(null, ResultCodeEnum.NOTLOGIN);

        // 如果token不为空且不为空字符串
        if (null != token && !"".equals(token)) {
            // 如果token未过期
            if (!JwtHelper.isExpiration(token)) {
                // 返回操作成功的结果
                result = Result.ok(null);
            }
        }
        return result;
    }

    /**
     * 用户注册
     *
     * @param user 用户对象
     * @return 返回注册结果
     */
    @PostMapping("/regist")
    public Result regist(@RequestBody User user) {
        Result result = null;
        // 根据用户名查找用户
        User registUser = userService.findByUsername(user.getUsername());
        // 如果用户不存在，进行注册操作
        if (null == registUser) {
            userService.regist(user);
            result = Result.ok(null);
        } else {
            // 如果用户名已存在，返回用户名已被使用的结果
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        return result;
    }

    /**
     * 检查用户名是否存在
     *
     * @param username 用户名
     * @return 返回检查结果
     */
    @PostMapping("checkUserName")
    public Result checkUserName(@RequestBody String username) {
        Result result = null;
        //根据用户名查找用户
        User registUser = userService.findByUsername(username);
        //如果用户名不存在,返回操作成功
        if (null == registUser) {
            result=Result.ok(null);
        }else {
            //如果用户名存在,返回用户名被占用
            result=Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        return result;
    }

    /**
     * 获取用户信息
     *
     * @param token 用户的token
     * @return 返回用户信息
     */
    @GetMapping("/getUserInfo")
    public Result getUserInfo(@RequestHeader("token") String token){
        Result result = null;

        //如果token不为空而且没有过期
        if (null !=token && !JwtHelper.isExpiration(token)){
            //获取用户Id
            int uid=JwtHelper.getUserId(token).intValue();
            //根据用户ID查找用户
            User loginUser=userService.findByUid(uid);
            //清空用户密码
            loginUser.setUserPwd("");
            //创建一个Map用于存放返回的数据
            Map<String,Object> data=new HashMap<>();
            //将用户信息存入map中
            data.put("loginUser" ,loginUser);
            //返回成功的操作并包含数据的结果
            result=Result.ok(data);
        }else {
            //如果token为空或者已经过期,返回未登录
            result=Result.build(null,ResultCodeEnum.NOTLOGIN);
        }
        return result;
    }


    /**
     * 用户登录
     *
     * @param user 用户对象
     * @return 返回登录结果
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        //根据用户名查找用户
        User loginUser=userService.findByUsername(user.getUsername());
        Result result=null;
        //如果用户存在
        if(null!=loginUser){
            //检查密码
            if (MD5Util.encrypt(user.getUserPwd()).equalsIgnoreCase(loginUser.getUserPwd())){
                //创建一个Map放返回数据
                Map<String,Object> data=new HashMap<>();
                //生成token
                data.put("token",JwtHelper.createToken(loginUser.getUid().longValue()));
                //返回成功的操作,并且包含数据的结果
                result=Result.ok(data);
            }else {
                //如果密码错误,返回密码错误
                result=Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
            }
        }else {
            //如果用户名不存在,返回用户名错误结果
            result=Result.build(null,ResultCodeEnum.USERNAME_ERROR);
        }
        return result;
    }
}
