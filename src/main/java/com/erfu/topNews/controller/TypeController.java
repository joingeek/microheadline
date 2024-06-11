package com.erfu.topNews.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TypeController
 *
 * 该类用于处理新闻类型相关的请求。新闻类型用于对新闻进行分类，例如科技、体育、娱乐等。
 *
 * 主要职责：
 * 1. 接收并处理前端关于新闻类型的请求。
 * 2. 调用对应的Service层方法进行业务处理。
 * 3. 返回处理结果给前端。
 */
@RestController
@RequestMapping("/type")
@CrossOrigin
public class TypeController {
    // 目前该类未包含具体的方法，未来可以添加处理新闻类型相关请求的方法。
}
