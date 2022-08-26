package com.oukele.springmvc_global_exception.exception_config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 全局异常处理器
 *
 * @author oukele
 */
@Component
public class GlobalException implements HandlerExceptionResolver {
    /**
     * 自定义resolveException方法
     *
     * @param request  http请求
     * @param response http响应
     * @param handler  抛出异常的处理器
     * @param ex       抛出异常的具体信息
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("发生异常的处理器: " + handler + ", 具体的异常信息: " + ex.getMessage());

        // 1.必须返回一个 ModelAndView, 否则会出现报错
        ModelAndView modelAndView = new ModelAndView();
        // 2.返回一个错误界面（要加入一个视图解析器）
        modelAndView.setViewName("error/error");
        // 3.返回一个错误的json格式文字信息
        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write("{\"code\":\"500\",\"msg\":\"服务器出现异常,请联系管理员进行处理\"}");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

}
