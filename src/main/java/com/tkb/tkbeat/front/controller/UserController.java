package com.tkb.tkbeat.front.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tkb.tkbeat.front.model.Carrier;
import com.tkb.tkbeat.front.model.User;
import com.tkb.tkbeat.front.model.UserInfo;
import com.tkb.tkbeat.front.repository.UserRepository;
import com.tkb.tkbeat.front.service.UserService;
import com.tkb.tkbeat.front.share.errormessage.ErrorMessage;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/info",method= {RequestMethod.GET,RequestMethod.POST})
	public String info(@SessionAttribute("userAccount")User user,Model model) {
		if(null!=user.getUserInfo()) {
			model.addAttribute("userInfo", user.getUserInfo());
			return "/front/user/userinfo";
			
		}
		else {
			Carrier carrier=new Carrier();
			carrier.setCode(ErrorMessage.UserInfoMissing.getCode());
			carrier.setMessage(ErrorMessage.UserInfoMissing.getDescription());
			carrier.setRedirect_url("/index");
			return "/toPath";
			
		}
		

	}
	
	@RequestMapping(value="/register",method= {RequestMethod.GET})
	public String go_register() {
		
		
		return "/front/user/register";
		
	}
	
	@RequestMapping(value="/register",method= {RequestMethod.POST})
	public String register(
			@ModelAttribute("user")User user,
			Model model
			) {
	Carrier carrier=new Carrier();
	Optional<User> newUser=userService.checkRegisterUser(user,carrier);
	if(newUser.isEmpty()) {
		carrier.setRedirect_url("/user/register");
		model.addAttribute("carrier", carrier);
	}
	else {
		User target=newUser.get();
		target.setUserInfo(new UserInfo());
		userRepository.save(target);
		carrier.setRedirect_url("/login");
		model.addAttribute("carrier", carrier);
	}
		
	return "/front/toPath";
		
	}

}
