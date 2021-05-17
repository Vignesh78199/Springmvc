package com.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Sample {
	@RequestMapping("/rest")
	public ModelAndView sample()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("rest.jsp");
		return mv;
	}
	

}
