package com.tkb.tkbeat.front.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tkb.tkbeat.front.model.User;
import com.tkb.tkbeat.front.service.UserService;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value= {"/",""},method= {RequestMethod.GET})
	public String gologin() {
		
		return "/front/login/login";
		
	}
	
	@RequestMapping(value= {"/",""},method= {RequestMethod.POST})
	public String login(@RequestParam(value="account",required=true)String account,
			@RequestParam(value="password",required=true)String password,
			Model model,
			HttpSession session) {
		
		Optional<User> check_user=userService.checklogin(account, password);
		if(check_user.isPresent()) {
			session.setAttribute("userAccount", check_user.get());
			model.addAttribute("message", "登入成功");
			model.addAttribute("redirect_url", "/index");
			return "/front/toPath";
		}
		model.addAttribute("message", "登入失敗");
		
		
		
		return "/front/login/login";
		
	}
}
