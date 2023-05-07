package com.nzr.animalap.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/view/**")
                .excludePathPatterns("/view/login")
                .excludePathPatterns("/view/checkrepeat")
                .excludePathPatterns("/view/forgot")
                .excludePathPatterns("/view/vcode")
                .excludePathPatterns("/view/signup");
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/fff/**")
                .excludePathPatterns("/fff")
                .excludePathPatterns("/fff/login");

    }
}
