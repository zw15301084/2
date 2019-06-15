package com.example.demo.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class URLInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 这里写各种判断逻辑
        // 如果没有………………，可以使用 reponse.send() 跳转页面。后面要跟return false,否则无法结束;
        String url = request.getRequestURI();
        System.out.println(url);
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL().toString());
        String regex = "^/[0-9]*/[0-9]*";
        if(url.matches(regex)){
            response.sendRedirect("/home");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
