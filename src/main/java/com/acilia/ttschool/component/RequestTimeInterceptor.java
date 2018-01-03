package com.acilia.ttschool.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.acilia.ttschool.repository.LogRepository;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
	private static final Log LOGGER= LogFactory.getLog(RequestTimeInterceptor.class);

	@Autowired
	@Qualifier("logrepository")
	private LogRepository logrepository; 
	
	
	//PRIMERO
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}
	
	//SEGUNDO
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime= (long) request.getAttribute("startTime");
		String url = request.getRequestURL().toString() ;
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		String username=null;
		if ((auth!=null) && auth.isAuthenticated()){
			username=auth.getName();
			com.acilia.ttschool.entity.Log log = new com.acilia.ttschool.entity.Log(new Date(),auth.getDetails().toString(),username,url);
			logrepository.save(log);
		}
		
		
		LOGGER.info("--URL: " + url + " -- TOTAL TIME-- " + (System.currentTimeMillis()-startTime) + " ms");
	}
	
	

}
