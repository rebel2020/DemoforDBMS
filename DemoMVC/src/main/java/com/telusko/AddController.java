package com.telusko;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.services.addService;

@Controller
public class AddController {

	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response)
	{
		int i=Integer.parseInt(request.getParameter("t1"));
		int j=Integer.parseInt(request.getParameter("t2"));
		
		addService as =new addService();
		int k=as.addNumbers(i, j);
		
		ModelAndView mv= new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result",k);
		return mv;
	}
	@RequestMapping("/Welcome")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login.jsp");
		mv.addObject("name",request.getParameter("t1"));
		return mv;
	}
}