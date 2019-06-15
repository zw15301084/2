package com.example.demo.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class URLInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        String url = request.getRequestURI();
        System.out.println(url);
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL().toString());
        String regex = "^/[0-9]*/[0-9]*";
        if(url.matches("/trainer/.*"))
        	return true;
        if(url.matches(regex)){
            response.sendRedirect("/home");
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
