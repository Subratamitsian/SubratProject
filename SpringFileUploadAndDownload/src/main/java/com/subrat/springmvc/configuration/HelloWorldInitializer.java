package com.subrat.springmvc.configuration;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class HelloWorldInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
 
		return new Class[] { HelloWorldConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return null;
	}

	@Override
	protected String[] getServletMappings() {
 
		return new String[] { "/"};
	}
	
	/***
	 * customizeRegistration in order to register the required MultiPartConfigElement to DispatcherServlet.
	 * The next step to activate multipart support 
	 * is to register a Bean of type StandardServletMultipartResolver
	 */
	
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration){
		registration.setMultipartConfig(getMultipartConfigElement());
	}
	
	private MultipartConfigElement getMultipartConfigElement(){
		MultipartConfigElement configElement= new MultipartConfigElement(LOCATION,MAX_FILE_SIZE,MAX_REQUEST_SIZE,FILE_SIZE_THRESHOLD);
		
		return configElement;
		
	}
    
    private static final String LOCATION = "C:/Users/subrat.panda/subrat";
 
    private static final long MAX_FILE_SIZE = 1024 * 1024 * 25;//25MB 
     
    private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 30;//30MB 
 
    private static final int FILE_SIZE_THRESHOLD = 0;
}
