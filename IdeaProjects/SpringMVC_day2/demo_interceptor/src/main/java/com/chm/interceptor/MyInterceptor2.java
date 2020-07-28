package com.chm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义的拦截器
 */
public class MyInterceptor2 implements HandlerInterceptor {
    /*
     * 预处理：在controller方法执行前执行
     * @param request
     * @param response
     * @param handler
     * @return  true：放行，执行下一个拦截器，若已无更多拦截器，则执行controller中的方法。
     *          false：不放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor被执行了——preHandle方法222222");
        return true;
    }
    /*@Override
    //不放行的情况：返回false
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor被执行了（自定义的拦截器）");
        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        return false;
    }*/


    /*
     * 后处理：在"controller方法执行后、success.jsp跳转前"执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor被执行了——postHandle方法222222");
        //request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);//请求转发到其他页面
    }


    /*
     * success.jsp页面执行后，会执行此方法（此方法最后执行）
     *     注意：此方法无法再跳转到其他页面。若试图用请求转发，则程序会出错。
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor被执行了——最后222222");
    }
}
