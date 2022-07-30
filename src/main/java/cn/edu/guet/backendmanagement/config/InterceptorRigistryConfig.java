package cn.edu.guet.backendmanagement.config;

import cn.edu.guet.backendmanagement.security.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorRigistryConfig implements WebMvcConfigurer {
        @Autowired
        private LoginInterceptor loginInterceptor;
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            //注册自己的拦截器,并设置拦截的请求路径
            //addPathPatterns为拦截此请求路径的请求
            //excludePathPatterns为不拦截此路径的请求
            registry.addInterceptor(loginInterceptor).addPathPatterns("/order/**");

        }
    }
