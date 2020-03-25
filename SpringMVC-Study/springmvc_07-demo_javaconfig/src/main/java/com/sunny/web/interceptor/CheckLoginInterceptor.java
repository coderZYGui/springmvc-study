package com.sunny.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckLoginInterceptor implements HandlerInterceptor {
    // 在请求处理方法之前执行
    // 如果返回true,执行下一个拦截器
    // 如果返回false,就不执行下一个拦截器

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 没有登录的情况
        if (request.getSession().getAttribute("user_in_session") == null){
            System.out.println("----------------");
            response.sendRedirect("/login.jsp");
            return false; // 阻止往后放行
        }
        // 放行,给下一个拦截器或者最终的处理器
        return true;
    }

    // 在请求处理方法执行之后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    // 在dispatcherServlet处理后执行,做清理工作
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
