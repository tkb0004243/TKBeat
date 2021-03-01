package com.tkb.tkbeat.front.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tkb.tkbeat.front.model.User;
import com.tkb.tkbeat.front.repository.UserRepository;
import com.tkb.tkbeat.front.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Optional<User> checklogin(String account, String password) {
		
		Optional<List<User>> check_user=userRepository.findByAccount(account);
		
		if(check_user.isPresent()) {
			List<User> user=check_user.get();
			String user_pwd=user.get(0).getPassword();
			
			if(user_pwd.equals(password)) {
				Optional<User> return_user=Optional.of(user.get(0));
				return return_user;
			}
		}
		return Optional.ofNullable(null);
	}

}
