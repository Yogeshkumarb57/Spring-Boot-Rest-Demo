package com.springboot.tutorial.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(method=RequestMethod.GET,value="/")
	public String getHome(HttpServletRequest req) {
		
		req.setAttribute("pageName", "HOME PAGE JSP");
		return "home.jsp";
	}

	@RequestMapping(method=RequestMethod.GET,value="/display")
	public String getDisplay(HttpServletRequest req) {

		return "display";
	}
}

