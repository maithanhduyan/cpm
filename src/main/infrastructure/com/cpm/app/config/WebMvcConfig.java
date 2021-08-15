package com.cpm.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/").resourceChain(false);
		
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/static/assets/");
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/assets/img/");
		
		registry.addResourceHandler("/vendor/bootstrap/**").addResourceLocations("/webjars/bootstrap/4.6.0/");
		registry.addResourceHandler("/vendor/jquery/**").addResourceLocations("/webjars/jquery/3.6.0/");
		registry.addResourceHandler("/vendor/font-awesome/**").addResourceLocations("/webjars/font-awesome/5.13.0/");
		registry.addResourceHandler("/vendor/jquery-easing/**").addResourceLocations("/webjars/jquery-easing/1.4.1/");
		registry.addResourceHandler("/vendor/chart.js/**").addResourceLocations("/webjars/chart.js/2.9.4/");
		registry.addResourceHandler("/vendor/datatables/**").addResourceLocations("/webjars/datatables/1.10.25/");

	}
}
