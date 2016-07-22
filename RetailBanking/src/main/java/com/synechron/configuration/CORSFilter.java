package com.synechron.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter{

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		HttpServletResponse httpResponse= (HttpServletResponse)response;
		httpResponse.setHeader("Access-Control-Allow-Origin","*");
		httpResponse.setHeader("Access-Control-Allow-Methods","POST,GET,PUT,DELETE,OPTION");
		httpResponse.setHeader("Access-Control-Max-Age","3600");
		httpResponse.setHeader("Access-Control-Allow-Headers","x-requested-with,Content-Type");
		filter.doFilter(request,response);
	}

	public void init(FilterConfig arg0) throws ServletException {}

}
