package com.tkb.tkbeat.front.service;

import java.util.Optional;
import com.tkb.tkbeat.front.model.Carrier;
import com.tkb.tkbeat.front.model.User;


public interface UserService {

	Optional<User> checklogin(String account,String password,Carrier carrier);
	
	Optional<User> checkRegisterUser(User newUser,Carrier carrier);
}
