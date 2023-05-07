package com.nzr.animalap.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handle) throws IOException{
        if(request.getSession().getAttribute("admin") == null){
            response.sendRedirect("/fff");

            return false;
        }
       return true;
    }
}
