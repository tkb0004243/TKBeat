package com.tkb.tkbeat.front.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tkb.tkbeat.front.model.User;


public interface UserService {

	Optional<User> checklogin(String account,String password);
}
