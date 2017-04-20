package com.webapp.foodister.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggingInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("---Request Completed---");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("---method executed---");
		HttpSession session = request.getSession();
		if (session.getAttribute("User")== null) {
			System.out.println("No user found");
			//response.sendRedirect("login.jsp");
			
		}
		else{
			
			System.out.println("User is logged in");
		}
		
		
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("---Before Method Execution---");
//		HttpSession session = request.getSession();
//		if (session.getAttribute("User")== null) {
//			System.out.println("No user found");
//			
//		}
//		else{
//			
//			System.out.println("User is logged in");
//		}
		
		return true;
	}

}
