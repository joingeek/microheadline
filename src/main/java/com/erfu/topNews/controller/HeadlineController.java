package com.erfu.topNews.controller;

import com.erfu.topNews.commons.Result;
import com.erfu.topNews.pojo.Headline;
import com.erfu.topNews.service.HeadlineService;
import com.erfu.topNews.service.impl.HeadlineServiceImpl;
import com.erfu.topNews.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * HeadlineController
 * <p>
 * 该类用于处理头条新闻相关的请求，包括发布、删除、更新和查询头条新闻。
 */
@RestController //将一个类标记为 RESTful 控制器
@RequestMapping("/headline")    //  映射请求路径。
@CrossOrigin //处理跨域请求。
public class HeadlineController {
    @Autowired //一个类中的成员变量或方法需要使用另一个类的实例时，可以使用 @Autowired 注解来自动注入所需的对象
    private HeadlineService headlineService;

    /**
     * 业务1: 根据ID查找头条新闻
     *
     * @param hid 头条新闻的ID
     * @return 返回包含头条新闻数据的结果
     */
    @PostMapping("/findHeadlineByHid")
    public Result findHeadlineByHid(@RequestParam int hid) {
        // 调用 headlineService 的 findByHid 方法根据 ID 查找头条新闻
        Headline headline = headlineService.findByHid(hid);
        // 创建一个 Map 用于存放返回的数据
        Map<String, Object> data = new HashMap<>();
        // 将查找到的头条新闻对象存入 Map 中
        data.put("headline", headline);
        // 返回操作成功并包含数据的结果
        return Result.ok(data);
    }


    /**
     * 业务2:更新头条新闻
     *
     * @param headline 需要更新的头条新闻对象
     * @return 返回操作结果
     */
    @PostMapping("/update")
    public Result updateHeadline(@RequestBody Headline headline) {
        // 调用 headlineService 的 updateHeadline 方法更新头条新闻
        headlineService.updateHeadline(headline);
        // 返回操作成功的结果
        return Result.ok(null);
    }

    /**
     * 发布头条新闻
     *
     * @param token    用户的token，用于获取发布者的ID
     * @param headline 发布的头条新闻对象
     * @return 返回操作结果
     */
    @PostMapping("/publish")
    public Result publish(@RequestHeader("token") String token, @RequestBody Headline headline) {
        // 使用 JwtHelper 工具类解析 token 获取发布者的 ID
        int publisher = JwtHelper.getUserId(token).intValue();
        // 设置发布者 ID 到头条新闻对象中
        headline.setPublisher(publisher);
        // 调用 headlineService 的 addHeadline 方法将头条新闻存入数据库
        headlineService.addHeadline(headline);
        // 返回操作成功的结果
        return Result.ok(null);
    }

    /**
     * 删除头条新闻
     *
     * @param hid 头条新闻的ID
     * @return 返回操作结果
     */
    @PostMapping("/removeByHid")
    public Result removeByHid(@RequestParam Integer hid) {
        // 调用 headlineService 的 removeHeadline 方法删除指定 ID 的头条新闻
        headlineService.removeHeadline(hid);
        // 返回操作成功的结果
        return Result.ok(null);
    }
}
