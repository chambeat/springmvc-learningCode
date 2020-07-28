package com.chm.utils;

import com.chm.exception.SysException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器（自定义的）
 */
public class SysExceptionResolver implements HandlerExceptionResolver {//必须实现HandlerExceptionResolver接口

    /*
     * 处理异常业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //1.获取异常对象
        SysException se = null;
        if (e instanceof SysException) {
            se = (SysException) e;
        } else {
            se = new SysException("系统正在维护。。。。。。");
        }
        //2.创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", se.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
