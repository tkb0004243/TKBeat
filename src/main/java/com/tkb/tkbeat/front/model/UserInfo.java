package com.tkb.tkbeat.front.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="user_info")
public class UserInfo extends BaseModel{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_info_id")
	private Integer userInfoId;
	
	@OneToOne(mappedBy = "userInfo")
	private User user;
	
	@Column(name="age")
	private Integer age=0;
	
	@Column(name="real_name")
	private String realName="0";
	
	@Column(name="address")
	private String address="0";
	
	@Column(name="profile")
	private String profile="0";
	
	@Column(name="email")
	private String email="0";

}
