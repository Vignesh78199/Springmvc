package com.spring.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogOutController {
	
	
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpSession session,HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView();
		session = request.getSession(false); 
		if (session != null)
		  session.setMaxInactiveInterval(1);
		 Cookie[] cookies = request.getCookies();
	        for(int i = 0; i< cookies.length ; ++i){
	            if(cookies[i].getName().equals("email")){
	                Cookie cookie = new Cookie("email", cookies[i].getValue());
	                cookie.setMaxAge(0);
	                response.addCookie(cookie);
	                cookies[i].setMaxAge(0);
	                response.addCookie(cookies[i]);
	            }}
	        
	mv.setViewName("Login.jsp");
	return mv;
	}
}
	        
