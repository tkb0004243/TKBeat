package com.tkb.tkbeat.front.util;

import java.util.Optional;

import com.tkb.tkbeat.front.model.User;

public class VertifyUtil {
	
	private VertifyUtil() {
		throw new AssertionError("Utility class cannot be instantiated"); 
	}
	
	
	public static boolean accountIsOk(String account) {
		
		if(null==account||"".equals(account)) {
			return false;
		}
		return true;
		
	}
	
	public static boolean passwordIsOk(String password) {
		
		if(null==password||"".equals(password)) {
			return false;
		}
		return true;
		
	}

	public static boolean nameIsOk(String name) {
	
	if(null==name||"".equals(name)) {
		return false;
	}
	return true;
	
}

	public static boolean phoneIsOk(String phone) {
	
	if(null==phone||"".equals(phone)) {
		return false;
	}
	return true;
	
}

}
