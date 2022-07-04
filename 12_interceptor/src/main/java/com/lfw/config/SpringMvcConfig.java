package com.lfw.config;

import com.lfw.controller.interceptor.ProjectInterceptor;
import com.lfw.controller.interceptor.ProjectInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({"com.lfw.controller"})   //"com.lfw.config"
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {

    //简化版
//    @Autowired
//    private ProjectInterceptor projectInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //配置多拦截器
//        registry.addInterceptor(projectInterceptor).addPathPatterns("/books", "/books");
//    }

    @Autowired
    private ProjectInterceptor projectInterceptor;
    @Autowired
    private ProjectInterceptor2 projectInterceptor2;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置多拦截器
        registry.addInterceptor(projectInterceptor).addPathPatterns("/books", "/books/*");
        registry.addInterceptor(projectInterceptor2).addPathPatterns("/books", "/books/*");
    }
}