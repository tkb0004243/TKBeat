package com.tkb.tkbeat.front.share.errormessage;


public enum ErrorMessage {
	
	//登入狀態顯示100~110
	OK(100,"登入成功"),
	ERRORPASSWORD(101,"密碼錯誤"),
	BAN(102,"此帳號無法使用"),
	NOMEMBER(103,"查無此使用者"),
	
	//註冊失敗顯示111~120
	
	RegisterOk(111,"註冊成功"),
	AccountErrorOrMissing(112,"註冊帳號遺失或驗證失敗"),
	PasswordErrorOrMissing(113,"註冊密碼遺失或驗證失敗"),
	PhoneErrorOrMissing(114,"註冊電話遺失或驗證失敗"),
	NameErrorOrMissing(115,"註冊姓名遺失或驗證失敗"),
	
	//會員個人資料 121~130
	UserInfoMissing(121,"會員資料遺失");
	
	
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
