package com.lfw.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


//web配置类简化开发，仅设置配置类类名即可
public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {


  protected Class<?>[] getRootConfigClasses() {
    return new Class[]{SpringMvcConfig.class};
  }

  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{SpringMvcConfig.class};
  }

  protected String[] getServletMappings() {
    return new String[]{"/"};
  }
}
