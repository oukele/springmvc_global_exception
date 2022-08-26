package com.oukele.springmvc_global_exception.exception_config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author oukele
 */
@ControllerAdvice
public class GlobalException1 {

    /**
     * @ExceptionHandler: 标明对哪种类别的异常进行处理
     * @ResponseBody: springmvc将响应一个 json格式信息
     * @return
     */
    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public String myHandler1(Exception ex){
        System.out.println("捕获算术异常, " + ex.getMessage());
        return "{\"code\":\"500\",\"msg\":\"服务器出现异常001,请联系管理员进行处理\"}";
    }

    /**
     * @ExceptionHandler: 标明对哪种类别的异常进行处理
     * @ResponseBody: springmvc将响应一个 json格式信息
     * @return
     */
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public String myHandler2(Exception ex){
//        return "{\"code\":\"500\",\"msg\":\"服务器出现异常001,请联系管理员进行处理\"}";
//    }

    /**
     * @ExceptionHandler: 标明对哪种类别的异常进行处理
     * 返回一个界面
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView myHandler3(Exception ex){
        System.out.println("获取所有异常, " + ex.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/error");
        return modelAndView;
    }

}
