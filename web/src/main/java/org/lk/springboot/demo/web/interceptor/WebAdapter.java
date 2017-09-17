package org.lk.springboot.demo.web.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration  
public class WebAdapter extends WebMvcConfigurerAdapter{  
  
    @Override  
    public void addInterceptors(InterceptorRegistry registry) {  
        //众多的拦截器组成了一个拦截器链  
        /** 
         * 主要方法说明： 
         * addPathPatterns 用于添加拦截规则 
         */  
        registry.addInterceptor(new PermissionHandlerInterceptor()).addPathPatterns("/**");  
        super.addInterceptors(registry);  
    }  
}  