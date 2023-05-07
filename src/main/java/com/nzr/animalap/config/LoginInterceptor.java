package com.nzr.animalap.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws IOException {
        if (request.getSession().getAttribute("user")==null){
            response.sendRedirect("/view/login");

            return false;
        }
        return true;
    }
}
