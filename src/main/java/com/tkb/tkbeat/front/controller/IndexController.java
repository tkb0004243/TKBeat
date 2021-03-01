package com.tkb.tkbeat.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/index")
public class IndexController {
	
	@RequestMapping(value= {"/",""},method= {RequestMethod.GET})
	public String index() {
		
		return "/front/index";
	}
	
	@RequestMapping(value= {"/",""},method= {RequestMethod.POST})
	public String login_index() {
		
		return "/front/index";
	}
	
	

}
