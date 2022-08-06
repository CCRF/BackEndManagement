package cn.edu.guet.backendmanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MySrcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/images/**").addResourceLocations("file:"+baseUploadPath);
        registry.addResourceHandler("/img/**").addResourceLocations("file:/usr/local/img/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
