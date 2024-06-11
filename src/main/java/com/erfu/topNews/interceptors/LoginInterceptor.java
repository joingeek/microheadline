package com.erfu.topNews.interceptors;

import com.erfu.topNews.commons.Result;
import com.erfu.topNews.commons.ResultCodeEnum;
import com.erfu.topNews.utils.JwtHelper;
import com.erfu.topNews.utils.WebUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 登录拦截器
 * 该拦截器用于拦截请求，检查请求中是否包含有效的令牌，如果不包含或令牌已过期，则返回未登录状态。
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 在处理请求之前调用
     * 该方法用于拦截请求，检查请求中是否包含有效的令牌，如果不包含或令牌已过期，则返回未登录状态。
     *
     * @param request  HttpServletRequest 对象，表示客户端的请求
     * @param response HttpServletResponse 对象，表示服务端的响应
     * @param handler  处理程序对象，表示处理当前请求的处理程序
     * @return 如果请求中包含有效的令牌，则返回 true；否则返回 false
     * @throws Exception 如果在处理请求过程中发生异常，则抛出异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求头中获取令牌
        String token = request.getHeader("token");
        if (token != null && !"".equals(token)) {
            // 检查令牌是否过期
            if (!JwtHelper.isExpiration(token)) {
                // 令牌未过期，返回 true，请求继续向下执行
                return true;
            }
        }
        // 如果令牌为空或已过期，返回未登录状态
        Result result = Result.build(null, ResultCodeEnum.NOTLOGIN);
        // 将结果以 JSON 格式写入响应中
        WebUtil.writeJson(response, result);
        // 返回 false，表示请求已终止
        return false;
    }
}
