package com.erfu.topNews.controller;

import com.erfu.topNews.commons.Result;
import com.erfu.topNews.pojo.Type;
import com.erfu.topNews.pojo.vo.HeadlineDetailVo;
import com.erfu.topNews.pojo.vo.HeadlineQueryVo;
import com.erfu.topNews.service.HeadlineService;
import com.erfu.topNews.service.TypeService;
import com.erfu.topNews.service.impl.HeadlineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PortalController
 *
 * 该类用于处理门户相关的请求，包括显示头条详情、分页查询头条新闻和查询所有新闻类型。
 */
@RestController
@RequestMapping("/portal")
@CrossOrigin
public class PortalController {

    @Autowired
    private TypeService typeService; // 自动注入 TypeService，用于处理新闻类型相关业务

    @Autowired
    private HeadlineService headlineService; // 自动注入 HeadlineService，用于处理头条新闻相关业务

    /**
     * 业务1:查询所有新闻类型
     *
     * @return 返回包含所有新闻类型的结果
     */
    @GetMapping("/findAllTypes")
    public Result findAllTypes(){
        // 调用 typeService 的 findAll 方法，查询所有新闻类型
        List<Type> typeList=typeService.findAll();
        // 返回操作成功并包含数据的结果
        return Result.ok(typeList);
    }

    /**
     * 业务2:分页查询头条新闻
     *
     * @param queryVo 查询条件封装对象
     * @return 返回包含分页信息的结果
     */
    @PostMapping("/findNewsPage")
    public Result findNewsPage(@RequestBody HeadlineQueryVo queryVo){
        //调用HeadlineService的findByPage方法,根据查询条件分页查询头条新闻
        Map PageInfo=headlineService.findByPage(queryVo);
        Map data=new HashMap<>();
        data.put("pageInfo",PageInfo);
        return Result.ok(data);
    }

    /**
     * 业务3:显示头条新闻详情
     *
     * @param hid 头条新闻的ID
     * @return 返回包含头条新闻详情的结果
     */
    @PostMapping("/showHeadlineDetail")
    public Result findHeadlineDetail(@RequestParam Integer hid){
        // 调用 headlineService 的 findHeadlineDetail 方法，根据头条新闻ID查找详情
        HeadlineDetailVo headlineDetailVo = headlineService.findHeadlineDetail(hid);
        // 创建一个 Map 用于存放返回的数据
        Map<String, Object> data = new HashMap<>();
        // 将查找到的头条新闻详情对象存入 Map 中
        data.put("headline", headlineDetailVo);
        // 返回操作成功并包含数据的结果
        return Result.ok(data);
    }
}
