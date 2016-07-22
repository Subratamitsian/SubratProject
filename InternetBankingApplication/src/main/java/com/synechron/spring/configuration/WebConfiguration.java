package com.synechron.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.synechron.spring")
public class WebConfiguration extends WebMvcConfigurerAdapter{

	@Override
	public  void configureViewResolvers(ViewResolverRegistry registry){
		
		InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		registry.viewResolver(viewResolver);
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/static/css/**").addResourceLocations("/resources/static/css/");
		registry.addResourceHandler("/resources/static/js/**").addResourceLocations("/resources/static/js/");
		registry.addResourceHandler("/resources/static/views/**").addResourceLocations("/resources/static/views/");
		registry.addResourceHandler("/resources/static/js/module/**").addResourceLocations("/resources/static/js/module/");
		registry.addResourceHandler("/resources/static/js/controller/**").addResourceLocations("/resources/static/js/controller/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars");
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        
          }
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configure){
		configure.enable();
	}
}
