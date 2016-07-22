package com.synechron.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityView;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.synechron")
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {
	
	@Bean
	public VelocityConfigurer velocityConfig(){
		VelocityConfigurer configurer= new VelocityConfigurer();
		configurer.setResourceLoaderPath("/WEB-INF/velocity/");
		return configurer;
	}
	
	@Override
	public void configureViewResolvers (ViewResolverRegistry registry){
		
		VelocityViewResolver viewResolver= new VelocityViewResolver();
		viewResolver.setViewClass(VelocityView.class);
		viewResolver.setPrefix("");
		viewResolver.setSuffix(".html");
		viewResolver.setExposeSpringMacroHelpers(true);
		viewResolver.setCache(true);
		registry.viewResolver(viewResolver);
		}
	
	
	/*@Override
	public void configureViewResolvers(ViewResolverRegistry registry){
		InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
		 viewResolver.setViewClass(JstlView.class);
	     viewResolver.setPrefix("");
	     viewResolver.setSuffix(".html");
	     registry.viewResolver(viewResolver);
	     
	   	}*/
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}
