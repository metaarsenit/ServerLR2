package io.swagger.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-02-08T19:54:28.896589640Z[GMT]")
@Configuration
public class SwaggerUiConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/swagger-ui/").setViewName("forward:/swagger-ui/index.html");
        registry.addViewController("/{spring:^(?!swagger-ui).*}$").setViewName("forward:/index.html");
        //registry.addViewController("/{spring:(?!swagger-ui).*$}").setViewName("forward:/index.html");
    }
}
