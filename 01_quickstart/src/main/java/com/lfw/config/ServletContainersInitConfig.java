package com.lfw.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

//web容器配置类 [初始化 Servlet 容器，并加载 SpringMVC 环境]
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {

  //加载springmvc配置类，产生springmvc容器(本质还是spring容器)
  protected WebApplicationContext createServletApplicationContext() {
    //初始化WebApplicationContext对象
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    //加载指定配置类
    ctx.register(SpringMvcConfig.class);
    return ctx;
  }

  //设置由 springmvc 控制器处理的请求映射路径
  protected String[] getServletMappings() {
    return new String[]{"/"};   //设置所有请求归 springmvc 处理
  }

  protected WebApplicationContext createRootApplicationContext() {
    return null;
  }
}
