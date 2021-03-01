package com.tkb.tkbeat.front.share.errormessage;


public enum ErrorMessage {
	
	//登入狀態顯示100~
	OK(100,"登入成功"),
	ERRORPASSWORD(101,"密碼錯誤"),
	BAN(102,"此帳號無法使用"),
	NOMEMBER(103,"查無此使用者");
	
	
	ErrorMessage(Integer number, String description) 
	{
		this.code = number;
		this.description = description;
	}
	
		private int code;
		private String description;
		
		public Integer getCode() {
		return code;
		}
		public String getDescription() {
		return description;
		}
	
	
	

}
