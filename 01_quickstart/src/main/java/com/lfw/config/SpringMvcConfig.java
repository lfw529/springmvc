package com.lfw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//springmvc 配置类，本质上还是一个spring配置类
@Configuration
@ComponentScan("com.lfw.controller")
public class SpringMvcConfig {

}
