package com.tkb.tkbeat.front.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tkb.tkbeat.front.model.Carrier;
import com.tkb.tkbeat.front.model.User;
import com.tkb.tkbeat.front.service.UserService;
import com.tkb.tkbeat.front.share.errormessage.ErrorMessage;

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
		Carrier carrier = new Carrier();
		Optional<User> check_user=userService.checklogin(account, password,carrier);
		if(check_user.isPresent()) {
			carrier.setRedirect_url("/index");
			session.setAttribute("userAccount", check_user.get());
			model.addAttribute("carrier", carrier);
			return "/front/toPath";
			
		}
		carrier.setRedirect_url("/login");
		model.addAttribute("carrier", carrier);
		return "/front/toPath";
		
	}
}
