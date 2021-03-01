package com.tkb.tkbeat.front.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tkb.tkbeat.front.model.Carrier;
import com.tkb.tkbeat.front.model.User;
import com.tkb.tkbeat.front.repository.UserRepository;
import com.tkb.tkbeat.front.service.UserService;
import com.tkb.tkbeat.front.share.errormessage.ErrorMessage;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Optional<User> checklogin(String account, String password,Carrier carrier) {
		Optional<List<User>> check_user=userRepository.findByAccount(account);
		if(check_user.isPresent()&&0!=check_user.get().size()) {
			System.out.println("進入");
			List<User> user=check_user.get();
			String user_pwd=user.get(0).getPassword();
			
			if(!String.valueOf(user_pwd).equals(password)) {
				 carrier.setCode(ErrorMessage.ERRORPASSWORD.getCode());
				 carrier.setMessage(ErrorMessage.ERRORPASSWORD.getDescription());
				 return Optional.ofNullable(null);
			}
			else if(!"1".equals(String.valueOf(user.get(0).getStatus()))) {
				carrier.setCode(ErrorMessage.BAN.getCode());
				carrier.setMessage(ErrorMessage.BAN.getDescription());
				return Optional.ofNullable(null);
			}
			carrier.setCode(ErrorMessage.OK.getCode());
			carrier.setMessage(ErrorMessage.OK.getDescription());
			return Optional.of(user.get(0));
		}
		carrier.setCode(ErrorMessage.NOMEMBER.getCode());
		carrier.setMessage(ErrorMessage.NOMEMBER.getDescription());
		return Optional.ofNullable(null);
	}

}
